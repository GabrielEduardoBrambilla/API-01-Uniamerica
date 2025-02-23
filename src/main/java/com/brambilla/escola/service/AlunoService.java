package com.brambilla.escola.service;

import com.brambilla.escola.entity.Aluno;
import org.springframework.stereotype.Service;
import com.brambilla.escola.repository.AlunoRepository;

import java.util.Optional;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public Aluno salvar(Aluno aluno) {
        Optional<Aluno> alunoExistente = alunoRepository.findByCpf(aluno.getCpf());
        if (alunoExistente.isPresent()) {
            throw new RuntimeException("CPF já cadastrado!");
        }

        if (aluno.getTelefone() == null || aluno.getTelefone().isBlank()) {
            aluno.setCadastroCompleto(false);
        } else {
            aluno.setCadastroCompleto(true);
        }


        return alunoRepository.save(aluno);
    }

    public Aluno atualizarAluno(Long id, Aluno alunoAtualizado) {
        Aluno alunoExistente = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado!"));

        alunoExistente.setNome(alunoAtualizado.getNome());
        alunoExistente.setCpf(alunoAtualizado.getCpf());
        alunoExistente.setTelefone(alunoAtualizado.getTelefone());

        // Ajustar cadastroCompleto baseado no telefone
        if (alunoAtualizado.getTelefone() == null || alunoAtualizado.getTelefone().isBlank()) {
            alunoExistente.setCadastroCompleto(false);
        } else {
            alunoExistente.setCadastroCompleto(true);
        }

        return alunoRepository.save(alunoExistente);
    }

}

