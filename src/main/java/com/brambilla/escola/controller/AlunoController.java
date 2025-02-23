package com.brambilla.escola.controller;

import com.brambilla.escola.repository.AlunoRepository;
import com.brambilla.escola.entity.Aluno;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/alunos")
@Validated
public class AlunoController {

        private final AlunoRepository alunoRepository;

        public AlunoController(AlunoRepository alunoRepository) {
            this.alunoRepository = alunoRepository;
        }

        @GetMapping
        public List<Aluno> listar() {
            return alunoRepository.findAll();
        }

        @PostMapping
        public ResponseEntity<Aluno> criar(@RequestBody @Valid Aluno aluno) {
            return ResponseEntity.ok(alunoRepository.save(aluno));
        }

}
