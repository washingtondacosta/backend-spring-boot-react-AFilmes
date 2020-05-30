package com.afilmes.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.afilmes.boot.domain.Filme;
import com.afilmes.boot.service.FilmeService;

@Controller
@RequestMapping("/filmes")
public class FilmeController {
	
	@Autowired
	private FilmeService service;

	@GetMapping("/cadastrar")
	public String cadastrar(Filme filme) {
		return "/filme/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("filmes", service.buscarTodos());
		return "/filme/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(Filme filme, RedirectAttributes attr) {
		service.salvar(filme);
		attr.addFlashAttribute("success", "Filme inserido com sucesso.");
		return "redirect:/filmes/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("filme", service.buscarPorId(id));
		return "/filme/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Filme filme, RedirectAttributes attr) {
		service.editar(filme);
		attr.addFlashAttribute("success", "Filme editado com sucesso.");
		return "redirect:/filmes/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		
		//if (service.filmeTemAvaliacoes(id)) {
		//	model.addAttribute("fail", "Filme não removido. Possui avaliacão(ões) vinculada(s).");
		//} else {
			service.excluir(id);
		//	model.addAttribute("success", "Filme excluído com sucesso.");
		//}
		
		return listar(model);
	}
	
	
}
