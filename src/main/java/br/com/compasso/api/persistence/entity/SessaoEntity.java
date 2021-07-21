package br.com.compasso.api.persistence.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sessoes_votacao")
public class SessaoEntity {

	
		
		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;

		
	    @Column(name="data_abertura")
	    private LocalDateTime dataAbertura;

	    @Column(name="data_encerramento")
	    private LocalDateTime dataFechamento;



	    @OneToOne(cascade=CascadeType.PERSIST)
	    private PautaEntity pauta;

	

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
			return pauta;
		}

		public void setPauta(PautaEntity pauta) {
			this.pauta = pauta;
		}

		public SessaoEntity(LocalDateTime dataAbertura, LocalDateTime dataFechamento, PautaEntity pauta) {
			this.dataAbertura = dataAbertura;
			this.dataFechamento = dataFechamento;
			this.pauta = pauta;
		}

		public SessaoEntity() {
		
		}

		

		
		

	
}
