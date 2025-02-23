package com.brambilla.escola.repository;

import com.brambilla.escola.entity.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TurmaRepository extends JpaRepository<Turma, Long> {
    @Query("SELECT t FROM Turma t WHERE t.ano BETWEEN :anoInicio AND :anoFim")
    List<Turma> findTurmasByAnoBetween(String anoInicio, String anoFim);

    @Query("SELECT t FROM Turma t WHERE t.semestre = :semestre AND t.ano = :ano")
    List<Turma> findTurmasBySemestreAndAno(String semestre, String ano);

    @Query("SELECT t FROM Turma t WHERE t.nome = :nome AND t.turno = :turno")
    List<Turma> findTurmasByNomeAndTurno( String nome, String turno);

    @Query("SELECT t FROM Turma t WHERE t.curso.nome = :nomeCurso")
    List<Turma> findTurmasByCursoNome( String nomeCurso);
}
