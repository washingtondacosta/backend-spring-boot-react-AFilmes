package com.afilmes.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.afilmes.boot.dao.AvaliacaoDao;
import com.afilmes.boot.domain.Avaliacao;

@Service @Transactional(readOnly = false)
public class AvaliacaoServiceImpl implements AvaliacaoService {
	
	@Autowired
	private AvaliacaoDao dao;

	@Override
	public Avaliacao salvar(Avaliacao avaliacao) {
		dao.save(avaliacao);
		return avaliacao;		
	}

	@Override
	public void editar(Avaliacao avaliacao) {
		dao.update(avaliacao);		
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);		
	}

	@Override @Transactional(readOnly = true)
	public Avaliacao buscarPorId(Long id) {
		
		return dao.findById(id);
	}

	@Override @Transactional(readOnly = true)
	public List<Avaliacao> buscarTodos() {
		
		return dao.findAll();
	}
}
