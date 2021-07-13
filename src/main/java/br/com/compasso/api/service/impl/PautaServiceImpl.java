package br.com.compasso.api.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.compasso.api.error.BadPautaException;
import br.com.compasso.api.error.PautaNotFoundException;
import br.com.compasso.api.model.request.PautaRequest;
import br.com.compasso.api.model.response.PautaResponse;
import br.com.compasso.api.persistence.domain.Pauta;
import br.com.compasso.api.persistence.repository.PautaRepository;
import br.com.compasso.api.service.Mapper;
import br.com.compasso.api.service.PautaService;

@Service
public class PautaServiceImpl implements PautaService {

	private static final Logger log = LoggerFactory.getLogger(PautaServiceImpl.class);

	@Autowired
	private PautaRepository pautaRepository;
	
	@Autowired
	private Mapper<PautaRequest, Pauta> requestMapperPauta;

	@Autowired
	private Mapper<Pauta, PautaResponse> responseMapperPauta;

	

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
	public Pauta get(Long id) {

		return pautaRepository.findById(id).orElseThrow(() -> new PautaNotFoundException(id));

	}

	@Override
	public List<Pauta> getAll() {

		return pautaRepository.findAll();
	}

	
	

	

	
	}



	


