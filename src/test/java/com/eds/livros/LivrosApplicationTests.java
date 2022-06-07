package com.eds.livros;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.eds.livros.modelo.Livro;
import com.eds.livros.repository.LivroRepository;
import com.eds.livros.services.LivroServices;
import com.fasterxml.jackson.databind.ObjectMapper;



@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LivrosApplicationTests {

	@Autowired
    private MockMvc mockMvc;
    
    @Autowired
    LivroRepository livroRepository;

    @Autowired
    LivroServices livroService;
		
	@Test
    public void testHelloWorld() throws Exception {
        
        mockMvc
                .perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello World"));
    }

    @Test
    public void testeInsereLivro() throws Exception {
        
        ObjectMapper objectMapper = new ObjectMapper();

        Livro livro = new Livro();
        Livro livro2 = new Livro();

        livro.setAutorLivro("Fabio");
        livro.setEditora("editoraFabio");
        livro.setQtdPaginas(100);
        livro.setTitulo("Teste1");

        livro2.setAutorLivro("Emerson");
        livro2.setEditora("editoraEmerson");
        livro2.setQtdPaginas(224);
        livro2.setTitulo("Teste1");

        mockMvc.perform((MockMvcRequestBuilders.post("/livros")
                .contentType(MediaType.APPLICATION_JSON))
                .content(objectMapper.writeValueAsString(livro))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated());

        mockMvc.perform((MockMvcRequestBuilders.post("/livros")
                .contentType(MediaType.APPLICATION_JSON))
                .content(objectMapper.writeValueAsString(livro2))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}

