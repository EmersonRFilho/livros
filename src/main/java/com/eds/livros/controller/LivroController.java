package com.eds.livros.controller;

import java.net.URI;
import java.util.List;

import com.eds.livros.controller.dto.LivroDto;
import com.eds.livros.controller.form.LivroForm;
import com.eds.livros.modelo.Livro;
import com.eds.livros.repository.LivroRepository;
import com.eds.livros.services.LivroServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class LivroController {
	
	@Autowired
	private LivroRepository livroRepository;

	@Autowired
	private LivroServices livroServices;
	
	// returns book list
	@GetMapping(value = "/livros")
	public List<LivroDto> lista() {
        List<Livro> livros = livroRepository.findAll();
        return LivroDto.converter(livros);
	}
	
	@PostMapping(value = "/livros", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LivroDto> cadastrar(@RequestBody LivroForm form, UriComponentsBuilder uriBuilder) {
		Livro livro = form.converter(livroRepository);

		if(livroServices.VerificaLivro(livro))
		{
			livroRepository.save(livro);
			URI uri = uriBuilder.path("/livro/{id}").buildAndExpand(livro.getId()).toUri();
			return ResponseEntity.created(uri).body(new LivroDto(livro));
		}
		else
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
