package com.afilmes.boot.dao;

import java.util.List;

import com.afilmes.boot.domain.Avaliacao;

public interface AvaliacaoDao {

    void save(Avaliacao avaliacao );

    void update(Avaliacao avaliacao);

    void delete(Long id);

    Avaliacao findById(Long id);

    List<Avaliacao> findAll();
}
