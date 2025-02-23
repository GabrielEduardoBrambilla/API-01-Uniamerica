package com.brambilla.escola.repository;

import com.brambilla.escola.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    @Query("Select a from Aluno a where a.nome LIKE :nome% ")
    public List<Aluno> findByAlunoStartName(String nome);

    @Query("Select a from Aluno a where a.telefone LIKE %:telefone% ")
    public List<Aluno> findByAlunoPhone(String telefone);

    @Query("Select a from Aluno a where a.turma.nome = :nomeTurma ")
    public List<Aluno> findByAlunoClass(String nomeTurma);

    public Optional<Aluno> findByCpf(String Cpf);
}
