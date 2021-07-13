package br.com.compasso.api.persistence.domain;

import java.util.function.Function;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pauta")
public class Pauta {

	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "titulo")
    private String titulo;

    public <R> R map(Function<Pauta, R> function){
        return function.apply(this);
    }

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

	public Pauta(String descricao, String titulo) {
		
		this.descricao = descricao;
		this.titulo = titulo;
	}

	public Pauta() {

	}
	
	
	
	
	

}
