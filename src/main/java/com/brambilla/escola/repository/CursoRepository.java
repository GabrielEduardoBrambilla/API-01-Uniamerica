package com.brambilla.escola.repository;

import com.brambilla.escola.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    @Query("SELECT c FROM Curso c WHERE LOWER(c.nome) = LOWER(:nome)")
    List<Curso> findByNome(String nome);

}
