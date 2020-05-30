package com.afilmes.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.afilmes.boot.dao.FilmeDao;
import com.afilmes.boot.domain.Filme;

@Service
public class FilmeServiceImpl implements FilmeService {
	
	@Autowired
	private FilmeDao dao;

	@Transactional(readOnly = false)
	@Override
	public Filme salvar(Filme filme) {
		dao.save(filme);
		return filme;		
	}

	@Transactional(readOnly = false)
	@Override
	public void editar(Filme filme) {
		dao.update(filme);		
	}

	@Transactional(readOnly = false)
	@Override
	public void excluir(Long id) {
		dao.delete(id);		
	}

	@Transactional(readOnly = true)
	@Override
	public Filme buscarPorId(Long id) {
		
		return dao.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Filme> buscarTodos() {
		
		return dao.findAll();
	}

	/*@Override
	public boolean filmeTemAvaliacoes(Long id) {
		if (buscarPorId(id).getAvaliacoes().isEmpty()) {
			return false;
		}
		return true;
	}*/

}
