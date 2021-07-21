package br.com.compasso.api.mapper;

import org.springframework.stereotype.Component;

import br.com.compasso.api.model.PautaRequest;
import br.com.compasso.api.model.SessaoRequest;
import br.com.compasso.api.persistence.entity.PautaEntity;
import br.com.compasso.api.persistence.entity.SessaoEntity;
@Component
public class CommonMapper {

	public PautaRequest mapPautaRequest(PautaEntity pautaEntity) {
		PautaRequest pautaRequest = new PautaRequest();
		pautaRequest.setDescricao(pautaEntity.getDescricao());
		pautaRequest.setTitulo(pautaEntity.getTitulo());
		return pautaRequest;

	}

	public SessaoEntity mapSessaoRequest(SessaoRequest sessaoRequest) {
		SessaoEntity entity = new SessaoEntity();
		entity.setDataAbertura(sessaoRequest.getDataAbertura());
		entity.setDataFechamento(sessaoRequest.getDataFechamento());
		entity.setPauta(sessaoRequest.getPauta());
		return entity;
	}
	

}
