package br.com.compasso.api.model.request;

import java.time.LocalDateTime;

import br.com.compasso.api.persistence.domain.Pauta;


public class SessaoRequest {

	
	    private LocalDateTime dataAbertura;

	  
	    private LocalDateTime dataFechamento;

	
	    private Pauta pauta;




	


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


		public Pauta getPauta() {
			return pauta;
		}


		public void setPauta(Pauta pauta) {
			this.pauta = pauta;
		}


		


	
}
