package com.afilmes.boot.dao;

import org.springframework.stereotype.Repository;

import com.afilmes.boot.domain.Filme;

@Repository
public class FilmeDaoImpl extends AbstractDao<Filme, Long> implements FilmeDao {

}
