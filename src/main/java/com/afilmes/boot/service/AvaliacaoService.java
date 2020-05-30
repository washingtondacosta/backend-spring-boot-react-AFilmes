package com.afilmes.boot.service;

import java.util.List;

import com.afilmes.boot.domain.Avaliacao;

public interface AvaliacaoService {

	Avaliacao salvar(Avaliacao avaliacao);
	
	void editar(Avaliacao avaliacao);
	
	void excluir(Long id);
	
	Avaliacao buscarPorId(Long id);
	
	List<Avaliacao> buscarTodos();
}
