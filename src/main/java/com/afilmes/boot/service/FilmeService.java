package com.afilmes.boot.service;

import java.util.List;

import com.afilmes.boot.domain.Filme;

public interface FilmeService {

    Filme salvar(Filme filme);

    void editar(Filme filme);

    void excluir(Long id);

    Filme buscarPorId(Long id);
    
    List<Filme> buscarTodos();

	/*boolean filmeTemAvaliacoes(Long id);*/
}
