package br.com.compasso.api.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.compasso.api.error.BadSessaoException;
import br.com.compasso.api.mapper.CommonMapper;
import br.com.compasso.api.model.PautaRequest;
import br.com.compasso.api.model.SessaoRequest;
import br.com.compasso.api.persistence.domain.PautaEntity;
import br.com.compasso.api.persistence.domain.SessaoEntity;
import br.com.compasso.api.persistence.repository.SessaoRepository;
import br.com.compasso.api.service.SessaoService;

@Service
public class SessaoServiceImpl implements SessaoService {

	private static final Logger log = LoggerFactory.getLogger(SessaoServiceImpl.class);

	@Autowired
	private SessaoRepository sessaoRepository;

	@Autowired
	private CommonMapper mapper;

	@Override
	public SessaoRequest criarNovaSessao(PautaEntity entity) {
		LocalDateTime fechamento = LocalDateTime.now().plusMinutes(1);
		try {

			PautaRequest pauta = mapper.mapPautaRequest(entity);
			SessaoRequest SessaoRequest = new SessaoRequest();
			SessaoRequest.setPauta(pauta);
			SessaoRequest.setDataAbertura(LocalDateTime.now());
			SessaoRequest.setDataFechamento(fechamento);
			SessaoEntity sessao = mapper.mapSessaoRequest(SessaoRequest);
			sessaoRepository.save(sessao);
			return SessaoRequest;
		} catch (Exception e) {
			log.info("error trying to create new sessao. {}", e.getMessage());
			throw new BadSessaoException("error");

		}
	}

	@Override
	public Optional<SessaoEntity> getSessaoId(Long id) {
		return sessaoRepository.findById(id);
	}

}
