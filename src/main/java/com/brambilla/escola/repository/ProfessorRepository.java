package com.brambilla.escola.repository;

import com.brambilla.escola.entity.Aluno;
import com.brambilla.escola.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    @Query("Select a from Aluno a where a.nome LIKE :nome% ")
    public List<Aluno> findByAlunoStartName(String nome);

    @Query("SELECT p FROM Professor p " +
            "WHERE p.nome LIKE CONCAT(:nameOrEspecialidade, '%') " +
            "   OR p.especialidade LIKE CONCAT(:nameOrEspecialidade, '%')")
    List<Professor> findProfessoresByNomeOrEspecialidade(String nameOrEspecialidade);

    @Query("SELECT p FROM Professor p WHERE p.email NOT LIKE '%@gmail.com'")
    List<Professor> findProfessoresByNotGmail();

    Optional<Professor> findByEmail(String email);

}
