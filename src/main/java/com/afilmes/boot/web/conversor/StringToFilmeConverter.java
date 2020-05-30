package com.afilmes.boot.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.afilmes.boot.domain.Filme;
import com.afilmes.boot.service.FilmeService;

@Component
public class StringToFilmeConverter implements Converter<String, Filme> {
	
	@Autowired
	private FilmeService service;

	@Override
	public Filme convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.buscarPorId(id);
	}

}
