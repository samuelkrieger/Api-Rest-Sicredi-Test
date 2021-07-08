package br.com.compasso.api.persistence.domain;

import java.time.LocalDateTime;
import java.util.function.Function;

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
public class Sessao {

	
		
		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;

		
	    @Column(name="data_abertura")
	    private LocalDateTime dataAbertura;

	    @Column(name="data_encerramento")
	    private LocalDateTime dataFechamento;



	    @OneToOne(cascade=CascadeType.PERSIST)
	    private Pauta pauta;

	
	    public <R> R map(Function<Sessao, R> function){
	        return function.apply(this);
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

		public Pauta getPauta() {
			return pauta;
		}

		public void setPauta(Pauta pauta) {
			this.pauta = pauta;
		}

		
		

	
}
