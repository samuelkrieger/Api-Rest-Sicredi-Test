package br.com.compasso.api.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.compasso.api.error.BadPautaException;
import br.com.compasso.api.error.BadSessaoException;
import br.com.compasso.api.error.BadVotoException;
import br.com.compasso.api.error.PautaNotFoundException;
import br.com.compasso.api.error.SessionNotFoundExcepiton;
import br.com.compasso.api.model.request.PautaRequest;
import br.com.compasso.api.model.request.SessaoRequest;
import br.com.compasso.api.model.response.PautaResponse;
import br.com.compasso.api.model.response.SessaoResponse;
import br.com.compasso.api.persistence.domain.OpcaoVoto;
import br.com.compasso.api.persistence.domain.Pauta;
import br.com.compasso.api.persistence.domain.Sessao;
import br.com.compasso.api.persistence.domain.Voto;
import br.com.compasso.api.persistence.repository.PautaRepository;
import br.com.compasso.api.persistence.repository.SessaoRepository;
import br.com.compasso.api.persistence.repository.VotoRepository;
import br.com.compasso.api.service.Mapper;
import br.com.compasso.api.service.PautaService;

@Service
public class PautaServiceImpl implements PautaService {

	private static final Logger log = LoggerFactory.getLogger(PautaServiceImpl.class);

	@Autowired
	private PautaRepository pautaRepository;

	@Autowired
	private SessaoRepository sessaoaRepository;

	@Autowired
	private VotoRepository votoRepository;

	@Autowired
	private Mapper<PautaRequest, Pauta> requestMapperPauta;

	@Autowired
	private Mapper<Pauta, PautaResponse> responseMapperPauta;

	@Autowired
	private Mapper<SessaoRequest, Sessao> requestMapperSessao;

	@Autowired
	private Mapper<Sessao, SessaoResponse> responseMapperSessao;

	@Override
	public PautaResponse criarNovaPauta(PautaRequest request) {
		try {
			Pauta pauta = requestMapperPauta.map(request);
			return pautaRepository.saveAndFlush(pauta).map((Pauta input) -> responseMapperPauta.map(input));
		} catch (Exception ex) {
			log.info("error trying to create new pauta. {}", ex.getMessage());
			throw new BadPautaException(request.getDescricao());
		}
	}

	@Override
	public Optional<Pauta> get(Long id) {

		return Optional.of(pautaRepository.findById(id).orElseThrow(() -> new PautaNotFoundException(id)));

	}

	@Override
	public Page<PautaResponse> getAll(Pageable pageable) {

		return pautaRepository.findAll(pageable).map(pautas -> this.responseMapperPauta.map(pautas));
	}

	@Override
	public SessaoResponse criarNovaSessao(PautaRequest request, LocalDateTime fechamento) {

		try {

			Pauta pauta = requestMapperPauta.map(request);
			SessaoRequest SessaoRequest = new SessaoRequest();
			SessaoRequest.setPauta(pauta);
			SessaoRequest.setDataAbertura(LocalDateTime.now());
			SessaoRequest.setDataFechamento(fechamento);
			Sessao sessao = requestMapperSessao.map(SessaoRequest);
			return sessaoaRepository.saveAndFlush(sessao).map((Sessao input) -> responseMapperSessao.map(input));
		} catch (Exception e) {
			log.info("error trying to create new sessao. {}", e.getMessage());
			throw new BadSessaoException(request.getDescricao());

		}
	}

	@Override
	public Sessao getSessao(Optional<Pauta> pauta) {

		return sessaoaRepository.findByPauta(pauta);
	}

	@Override
	public Voto votar(Long id, OpcaoVoto opcao) {
		try {
			Voto voto = new Voto();
			Optional<Pauta> pauta = pautaRepository.findById(id);
			Sessao sessao = getSessao(pauta);
			voto.setOpcaoVoto(opcao);
			voto.setSessao(sessao);
			voto.setDataHora(LocalDateTime.now());

			return votoRepository.saveAndFlush(voto);
		} catch (Exception ex) {
			log.info("error trying created voto. {}", ex.getMessage());
			throw new BadVotoException(opcao.toString());
		}
	}

	@Override
	public Optional<Sessao> getSessaoId(Long id) {

		return Optional.of(sessaoaRepository.findById(id).orElseThrow(() -> new SessionNotFoundExcepiton(id)));
	}

	@Override
	public Page<Voto> getVotos(Pageable pageable) {
		return votoRepository.findAll(pageable);
	}


	@Override
	public String resultado() {
		List<Voto> listSim = new ArrayList<>();
	    List<Voto> listNao = new ArrayList<>();
		
	    listSim.addAll(votoRepository.findAllOpcaoVotoSim());
	    listNao.addAll(votoRepository.findAllOpcaoVotoNao());
	    if(listSim.size() > listNao.size()) {
	    	return "Sim ganhou";
	    }
	    if(listSim.size() <  listNao.size()) {
	    	return "Nao ganhou";
	    }
		
		return "empatado";
	}
	}



	


