package br.com.compasso.api.model;

import java.time.LocalDateTime;

import br.com.compasso.api.persistence.entity.PautaEntity;

public class SessaoRequest {
	private Long id;

	private LocalDateTime dataAbertura;

	private LocalDateTime dataFechamento;

	@SuppressWarnings("unused")
	private PautaRequest pauta;
	
	private PautaEntity pautaEntity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(LocalDateTime dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public LocalDateTime getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(LocalDateTime dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public PautaEntity getPauta() {
		return pautaEntity;
	}

	public void setPauta(PautaRequest pauta) {
		this.pauta = pauta;
	}

	

}
