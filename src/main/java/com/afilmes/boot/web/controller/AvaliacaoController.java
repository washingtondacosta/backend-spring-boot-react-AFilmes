package com.afilmes.boot.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.afilmes.boot.domain.Avaliacao;
import com.afilmes.boot.domain.Filme;
import com.afilmes.boot.service.AvaliacaoService;
import com.afilmes.boot.service.FilmeService;

@Controller
@RequestMapping("/avaliacoes")
public class AvaliacaoController {
	
	@Autowired
	private AvaliacaoService avaliacaoService;
	@Autowired
	private FilmeService filmeService;

	@GetMapping("/cadastrar")
	public String cadastrar(Avaliacao avaliacao) {
		return "/avaliacao/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("avaliacoes", avaliacaoService.buscarTodos());
		return "/avaliacao/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(Avaliacao avaliacao, RedirectAttributes attr) {
		avaliacaoService.salvar(avaliacao);
		attr.addFlashAttribute("success", "Avaliação inserido com sucesso.");
		return "redirect:/avaliacoes/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("avaliacao", avaliacaoService.buscarPorId(id));
		return "avaliacao/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Avaliacao avaliacao, RedirectAttributes attr) {
		avaliacaoService.editar(avaliacao);
		attr.addFlashAttribute("success", "Registro atualizado com sucesso.");
		return "redirect:/avaliacoes/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
			avaliacaoService.excluir(id);
			attr.addFlashAttribute("success", "Avaliação excluida com sucesso.");
		
		return "redirect:/avaliacoes/listar";
	}
	
	@ModelAttribute("filmes")
	public List<Filme> listaDeFilmes() {
		return filmeService.buscarTodos();
	}	
}
