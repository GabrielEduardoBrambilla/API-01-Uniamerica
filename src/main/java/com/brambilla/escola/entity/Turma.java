package com.brambilla.escola.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    private String semestre;
    @NotBlank
    private String ano;
    @NotBlank
    private String turno;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false) // Turma deve estar associada a um curso
    private Curso curso;

    @OneToMany(mappedBy = "turma")
    private Set<Aluno> alunos = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "turma_professor",
            joinColumns = @JoinColumn(name = "turma_id"),
            inverseJoinColumns = @JoinColumn(name = "professor_id"))
    private Set<Professor> professores = new HashSet<>();
}
