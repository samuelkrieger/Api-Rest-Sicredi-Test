package br.com.compasso.api.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.compasso.api.error.BadPautaException;
import br.com.compasso.api.error.PautaNotFoundException;
import br.com.compasso.api.mapper.CommonMapper;
import br.com.compasso.api.model.PautaRequest;
import br.com.compasso.api.persistence.domain.PautaEntity;
import br.com.compasso.api.persistence.repository.PautaRepository;
import br.com.compasso.api.service.PautaService;

@Service
public class PautaServiceImpl implements PautaService {

	private static final Logger log = LoggerFactory.getLogger(PautaServiceImpl.class);

	@Autowired
	private PautaRepository pautaRepository;
	
	
	@Autowired
	private  CommonMapper mapper;
   
	

	@Override
	public PautaRequest criarNovaPauta(PautaEntity entity) {
		try {
			pautaRepository.save(entity);
			PautaRequest request =mapper.mapPautaRequest(entity);

			return  request;
		} catch (Exception ex) {
			log.info("error trying to create new pauta. {}", ex.getMessage());
			throw new BadPautaException("error");
		}
	}

	@Override
	public PautaEntity get(Long id) {

		return pautaRepository.findById(id).orElseThrow(() -> new PautaNotFoundException(id));

	}

	@Override
	public List<PautaEntity> getAll() {

		return pautaRepository.findAll();
	}

	
	

	

	
	}



	


