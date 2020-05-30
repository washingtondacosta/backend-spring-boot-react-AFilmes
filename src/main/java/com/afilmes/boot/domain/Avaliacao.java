package com.afilmes.boot.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "AVALIACOES")
public class Avaliacao extends AbstractEntity<Long> {

	@Column(name = "nota", nullable = false, length = 2)
	private int nota;
	
	@Column(name = "nomeUsuario", nullable = false, length = 100)
	private String nomeUsuario;
	
	@Column(name = "comentario", nullable = true, length = 2000)
	private String comentario;
	
	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	@ManyToOne
	@JoinColumn(name = "idFilmeFk")
	private Filme filme;

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}
	
}
