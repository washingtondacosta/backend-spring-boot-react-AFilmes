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

import com.afilmes.boot.domain.Filme;
import com.afilmes.boot.service.FilmeServiceImpl;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
public class FilmeResource {
	
	 @Autowired
	  private FilmeServiceImpl filmeManagementService;
	 
	 @GetMapping("/afilmes/{username}/filmes")
		public List<Filme> getAllFilmes(@PathVariable String username) {
			return filmeManagementService.buscarTodos();
		}
	 

	@GetMapping("/afilmes/{username}/filmes/{id}")
	public Filme getFilme(@PathVariable String username, @PathVariable long id) {
		return filmeManagementService.buscarPorId(id);
	}

	@DeleteMapping("/afilmes/{username}/filmes/{id}")
	public void deleteFilme(@PathVariable String username, @PathVariable long id) {

		filmeManagementService.excluir(id);
	}

	@PutMapping("/afilmes/{username}/filmes/{id}")
	public ResponseEntity<Filme> updateFilme(@PathVariable String username, @PathVariable long id,
			@RequestBody Filme filme) {

		filmeManagementService.editar(filme);

		return new ResponseEntity<Filme>(filme, HttpStatus.OK);
	}
	
	@PostMapping("/afilmes/{username}/filmes")
	public ResponseEntity<Void> createFilme(@PathVariable String username, @RequestBody Filme filme) {

		Filme createdFilme = filmeManagementService.salvar(filme);

		// Location
		// Get current resource url
		/// {id}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdFilme.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

}