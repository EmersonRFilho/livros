package com.eds.livros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.eds.livros.modelo.Livro;
import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

	@Query(value = "SELECT * from Livro WHERE titulo = ?1",
			nativeQuery = true)
	List<Livro> findAllByTitulo(String titulo);
	
	@Query(value = "SELECT * from Livro WHERE id = ?1",
			nativeQuery = true)
	Livro findByID(int id);

}
