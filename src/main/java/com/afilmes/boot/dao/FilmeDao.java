package com.afilmes.boot.dao;

import java.util.List;

import com.afilmes.boot.domain.Filme;

public interface FilmeDao {

    void save(Filme filme);

    void update(Filme filme);

    void delete(Long id);

    Filme findById(Long id);

    List<Filme> findAll();
}
