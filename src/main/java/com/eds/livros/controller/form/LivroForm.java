package com.eds.livros.controller.form;

import com.eds.livros.modelo.Livro;
import com.eds.livros.repository.LivroRepository;

public class LivroForm {

	private String titulo;
	private String autorLivro;
	private String editora;
    private int qtdPaginas;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutorLivro() {
		return autorLivro;
	}

	public void setAutorLivro(String autorLivro) {
		this.autorLivro = autorLivro;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

    public int getQtdPaginas(){
        return qtdPaginas;
    }

    public void setQtdPaginas(int qtdPaginas){
        this.qtdPaginas = qtdPaginas;
    }

	public Livro converter(LivroRepository cursoRepository) {
		return new Livro(titulo, autorLivro, editora, qtdPaginas);
	}

}
