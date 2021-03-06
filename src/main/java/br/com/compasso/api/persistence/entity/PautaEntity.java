package br.com.compasso.api.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pauta")
public class PautaEntity {

	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "titulo")
    private String titulo;

 

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public PautaEntity(String descricao, String titulo) {
		
		this.descricao = descricao;
		this.titulo = titulo;
	}

	public PautaEntity() {

	}
	
	
	
	
	

}
