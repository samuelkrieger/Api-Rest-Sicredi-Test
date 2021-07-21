package br.com.compasso.api.mapper;

import br.com.compasso.api.model.PautaRequest;
import br.com.compasso.api.model.SessaoRequest;
import br.com.compasso.api.persistence.domain.PautaEntity;
import br.com.compasso.api.persistence.domain.SessaoEntity;

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
