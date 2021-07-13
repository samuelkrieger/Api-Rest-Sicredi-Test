package br.com.compasso.api.service.impl;

import java.time.LocalDateTime;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.compasso.api.error.BadSessaoException;
import br.com.compasso.api.model.request.PautaRequest;
import br.com.compasso.api.model.request.SessaoRequest;
import br.com.compasso.api.model.response.SessaoResponse;
import br.com.compasso.api.persistence.domain.Pauta;
import br.com.compasso.api.persistence.domain.Sessao;
import br.com.compasso.api.persistence.repository.SessaoRepository;
import br.com.compasso.api.service.Mapper;
import br.com.compasso.api.service.SessaoService;
@Service
public class SessaoServiceImpl implements SessaoService{
	
	private static final Logger log = LoggerFactory.getLogger(SessaoServiceImpl.class);
	
	@Autowired
	private SessaoRepository sessaoRepository;
	
	@Autowired
	private Mapper<SessaoRequest, Sessao> requestMapperSessao;

	@Autowired
	private Mapper<Sessao, SessaoResponse> responseMapperSessao;
	
	@Autowired
	private Mapper<PautaRequest, Pauta> requestMapperPauta;
	
	@Override
	public SessaoResponse criarNovaSessao(PautaRequest request, LocalDateTime fechamento) {

		try {

			Pauta pauta = requestMapperPauta.map(request);
			SessaoRequest SessaoRequest = new SessaoRequest();
			SessaoRequest.setPauta(pauta);
			SessaoRequest.setDataAbertura(LocalDateTime.now());
			SessaoRequest.setDataFechamento(fechamento);
			Sessao sessao = requestMapperSessao.map(SessaoRequest);
			return sessaoRepository.saveAndFlush(sessao).map((Sessao input) -> responseMapperSessao.map(input));
		} catch (Exception e) {
			log.info("error trying to create new sessao. {}", e.getMessage());
			throw new BadSessaoException(request.getDescricao());

		}
	}

	@Override
	public Optional<SessaoResponse> getSessaoId(Long id) {
		return sessaoRepository.findById(id).map(this.responseMapperSessao::map);
	}


	
	

}
