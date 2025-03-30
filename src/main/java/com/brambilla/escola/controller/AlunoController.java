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
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class AlunoController {

        private final AlunoRepository alunoRepository;

        public AlunoController(AlunoRepository alunoRepository) {
            this.alunoRepository = alunoRepository;
        }

        @GetMapping(path = "/findAll")
        public List<Aluno> listar() {
            return alunoRepository.findAll();
        }

        @PostMapping(path = "/save")
        public ResponseEntity<Aluno> criar(@RequestBody @Valid Aluno aluno) {
            System.out.println(aluno);
            return ResponseEntity.ok(alunoRepository.save(aluno));
        }

        @PutMapping(path = "/update/{id}")
        public ResponseEntity<Aluno> update(@RequestBody @Valid Aluno aluno, @PathVariable Long id) {
            System.out.println(aluno);
            return ResponseEntity.ok(alunoRepository.save(aluno));
        }

    @DeleteMapping(path = "/deleteById/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        alunoRepository.deleteById(id);
        return ResponseEntity.ok("Aluno deletado com sucesso!");
    }

}
