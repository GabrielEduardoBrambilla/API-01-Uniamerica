package com.brambilla.escola.service;

import com.brambilla.escola.entity.Professor;
import com.brambilla.escola.repository.ProfessorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

    @Service
    public class ProfessorService {

        private final ProfessorRepository professorRepository;

        public ProfessorService(ProfessorRepository professorRepository) {
            this.professorRepository = professorRepository;
        }

        // ✅ INSERÇÃO: Não permitir email duplicado + Bloquear "@outlook.com"
        @Transactional
        public Professor salvarProfessor(Professor professor) {

            Optional<Professor> professorExistente = professorRepository.findByEmail(professor.getEmail());
            if (professorExistente.isPresent()) {
                throw new RuntimeException("Email já cadastrado!");
            }

            if (professor.getEmail().toLowerCase().contains("@outlook.com")) {
                throw new RuntimeException("Domínio de e-mail não permitido");
            }

            return professorRepository.save(professor);
        }
    }

