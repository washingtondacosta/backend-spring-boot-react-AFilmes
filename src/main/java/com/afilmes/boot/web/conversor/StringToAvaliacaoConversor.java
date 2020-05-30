package com.afilmes.boot.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.afilmes.boot.domain.Avaliacao;
import com.afilmes.boot.service.AvaliacaoService;

@Component
public class StringToAvaliacaoConversor implements Converter<String, Avaliacao> {

	@Autowired
	private AvaliacaoService service;
	
	@Override
	public Avaliacao convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.buscarPorId(id);
	}
}
