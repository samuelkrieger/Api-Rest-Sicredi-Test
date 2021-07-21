package br.com.compasso.api.persistence.entity;

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
public class VotoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "opcao")
	private OpcaoVotoEntity opcaoVoto;

	@Column(name = "data")
	private LocalDateTime dataHora;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_sessao")
	private SessaoEntity sessao;

	public OpcaoVotoEntity getOpcaoVoto() {
		return opcaoVoto;
	}

	public void setOpcaoVoto(OpcaoVotoEntity opcaoVoto) {
		this.opcaoVoto = opcaoVoto;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public SessaoEntity getSessao() {
		return sessao;
	}

	public void setSessao(SessaoEntity sessao) {
		this.sessao = sessao;
	}

}
