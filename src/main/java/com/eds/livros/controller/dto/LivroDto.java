package com.eds.livros.controller.dto;
import com.eds.livros.modelo.Livro;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;



public class LivroDto {

	private Long id;
	private String titulo;
	private String autorLivro;
    private String editora;
	private LocalDateTime dataCriacao;
	
	public LivroDto(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
		this.autorLivro = livro.getAutorLivro();
        this.editora = livro.getEditora();
		this.dataCriacao = livro.getDataCriacao();
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAutorLivro() {
		return autorLivro;
	}
    
    public String getEditora(){
        return editora;
    }

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public static List<LivroDto> converter(List<Livro> livros) {
		return livros.stream().map(LivroDto::new).collect(Collectors.toList());
	}

}
