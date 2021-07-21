package br.com.compasso.api.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.compasso.api.error.BadVotoException;
import br.com.compasso.api.persistence.entity.OpcaoVotoEntity;
import br.com.compasso.api.persistence.entity.SessaoEntity;
import br.com.compasso.api.persistence.entity.VotoEntity;
import br.com.compasso.api.persistence.repository.PautaRepository;
import br.com.compasso.api.persistence.repository.SessaoRepository;
import br.com.compasso.api.persistence.repository.VotoRepository;
import br.com.compasso.api.service.VotoService;

@Service
public class VotoServiceImpl implements VotoService {

	private static final Logger log = LoggerFactory.getLogger(VotoServiceImpl.class);

	@Autowired
	private PautaRepository pautaRepository;

	@Autowired
	private VotoRepository votoRepository;

	@Autowired
	private SessaoRepository sessaoRepository;

	@Override
	public VotoEntity votar(Long id, OpcaoVotoEntity opcao) {

		try {
			VotoEntity voto = new VotoEntity();
			SessaoEntity sessao = sessaoRepository.findByPauta(pautaRepository.findById(id).get());
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
	public List<VotoEntity> getAll() {
		return votoRepository.findAll();
	}

	@Override
	public String resultado() {
		List<VotoEntity> listSim = new ArrayList<>();
		List<VotoEntity> listNao = new ArrayList<>();

		listSim.addAll(votoRepository.findAllOpcaoVotoSim());
		listNao.addAll(votoRepository.findAllOpcaoVotoNao());
		if (listSim.size() > listNao.size()) {
			return "Sim ganhou";
		}
		if (listSim.size() < listNao.size()) {
			return "Nao ganhou";
		}

		return "empatado";

	}

}
