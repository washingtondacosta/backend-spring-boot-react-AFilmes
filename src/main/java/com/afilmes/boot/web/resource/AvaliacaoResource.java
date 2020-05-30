package com.afilmes.boot.web.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.afilmes.boot.domain.Avaliacao;
import com.afilmes.boot.domain.Filme;
import com.afilmes.boot.service.AvaliacaoServiceImpl;
import com.afilmes.boot.service.FilmeServiceImpl;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
public class AvaliacaoResource {
	
	 @Autowired
	  private AvaliacaoServiceImpl avaliacaoManagementService;
	 
	 @GetMapping("/afilmes/{username}/avaliacoes")
		public List<Avaliacao> getAllAvaliacoes(@PathVariable String username) {
			return avaliacaoManagementService.buscarTodos();
		}
	 

	@GetMapping("/afilmes/{username}/avaliacoes/{id}")
	public Avaliacao getAvaliacao(@PathVariable String username, @PathVariable long id) {
		return avaliacaoManagementService.buscarPorId(id);
	}

	@DeleteMapping("/afilmes/{username}/avaliacoes/{id}")
	public void deleteAvaliacao(@PathVariable String username, @PathVariable long id) {

		avaliacaoManagementService.excluir(id);
	}

	@PutMapping("/afilmes/{username}/avaliacoes/{id}")
	public ResponseEntity<Avaliacao> updateAvaliacao(@PathVariable String username, @PathVariable long id,
			@RequestBody Avaliacao avaliacao) {

		avaliacaoManagementService.editar(avaliacao);

		return new ResponseEntity<Avaliacao>(avaliacao, HttpStatus.OK);
	}
	
	@PostMapping("/afilmes/{username}/avaliacoes")
	public ResponseEntity<Void> createAvaliacao(@PathVariable String username, @RequestBody Avaliacao avaliacao) {

		Avaliacao createdAvaliacao = avaliacaoManagementService.salvar(avaliacao);

		// Location
		// Get current resource url
		/// {id}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdAvaliacao.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

}