package com.eds.livros.services;

import java.util.List;

import com.eds.livros.modelo.Livro;
import com.eds.livros.repository.LivroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LivroServices {

    @Autowired
    private LivroRepository livroRepository;

    
    //recebe o livro a ser inseriddo e verifica se algum livro com o mesmo título ja existe cadastrado
    public Boolean VerificaLivro(Livro livro)
    {
        List<Livro> jaExiste = livroRepository.findAllByTitulo(livro.getTitulo());
        
        if(jaExiste.size() == 0)
            return true;
        else
            return false;
    }
}
