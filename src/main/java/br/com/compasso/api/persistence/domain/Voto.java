package br.com.compasso.api.persistence.domain;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "votos")
public class Voto {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;

	    @Column(name="opcao")
	    private OpcaoVoto opcaoVoto;

	    @Column(name="data")
	    private LocalDateTime dataHora;

	    @ManyToOne(cascade=CascadeType.PERSIST)
	    @JoinColumn(name="id_sessao")
	    private Sessao sessao;

	

		public OpcaoVoto getOpcaoVoto() {
			return opcaoVoto;
		}

		public void setOpcaoVoto(OpcaoVoto opcaoVoto) {
			this.opcaoVoto = opcaoVoto;
		}

		public LocalDateTime getDataHora() {
			return dataHora;
		}

		public void setDataHora(LocalDateTime dataHora) {
			this.dataHora = dataHora;
		}


		
		public Sessao getSessao() {
			return sessao;
		}

		public void setSessao(Sessao sessao) {
			this.sessao = sessao;
		}

	   

}
