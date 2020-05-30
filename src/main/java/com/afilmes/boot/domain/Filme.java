package com.afilmes.boot.domain;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "FILMES")
public class Filme extends AbstractEntity<Long> {

	@Column(name = "titulo", nullable = false, unique = true, length = 100)
	private String titulo;
	
	@Column(name = "sinopse", nullable = true, length = 2000)
	private String sinopse;
	
	@Column(name = "anoLancamento", nullable = true, length = 4)
	private String anoLancamento;
	
	@Column(name = "produtores", nullable = true, length = 200)
	private String produtores;
	
	@Column(name = "protagonistas", nullable = true, length = 200)
	private String protagonistas;
	
	public String getProtagonistas() {
		return protagonistas;
	}

	public void setProtagonistas(String protagonistas) {
		this.protagonistas = protagonistas;
	}

	public String getProdutores() {
		return produtores;
	}

	public void setProdutores(String produtores) {
		this.produtores = produtores;
	}

	public String getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(String anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	@OneToMany(mappedBy = "filme")
	private List<Avaliacao> avaliacoes;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/*public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}*/
	
 	
	@Transient
	private double mediaAvaliacoes;
	
	public double getMediaAvaliacoes() {   			
    
		double somaEstrelas = 0;
		int qtdAvaliacoes = avaliacoes.size();	
	    
	    for (Avaliacao avaliacao : avaliacoes) {
	      
	        somaEstrelas += avaliacao.getNota(); 
	    }
      
	    return somaEstrelas/qtdAvaliacoes;
		 
	}
}
