package com.brambilla.escola.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Pattern(regexp = "^[A-Za-zÀ-ÖØ-öø-ÿ]{2,} [A-Za-zÀ-ÖØ-öø-ÿ]{2,}(?: [A-Za-zÀ-ÖØ-öø-ÿ]+)*$",
            message = "Erro minimo aceito são duas palavras ")
    private String nome;

    @CPF
    private String cpf;

    @Pattern(regexp = "^\\+?[1-9]\\d{1,14}$", message = "Numero invalido")
    private String telefone;

    @ManyToOne
    private Turma turma;

    private boolean cadastroCompleto;

}
