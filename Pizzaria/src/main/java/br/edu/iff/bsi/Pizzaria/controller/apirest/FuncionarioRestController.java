package br.edu.iff.bsi.Pizzaria.controller.apirest;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iff.bsi.Pizzaria.entities.*;
import br.edu.iff.bsi.Pizzaria.service.*;
import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping(path = "/api/v1/funcionario")
public class FuncionarioRestController {

    @Autowired
    public FuncionarioService funcionarioServ;

    @PostMapping("")
    public ResponseEntity<Funcionario> addFuncionario(@RequestBody Funcionario funcionario) {
        funcionarioServ.salvarFuncionario(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> atualizarFuncionario(
            @PathVariable Long id,
            @RequestBody Funcionario funcionarioAtualizado
    ) throws NotFoundException {
        Funcionario funcionario = funcionarioServ.realizarAtualizacaoFuncionario(id, funcionarioAtualizado);
		return ResponseEntity.ok(funcionario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFuncionario(@PathVariable Long id) {
        funcionarioServ.removerFuncionario(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("")
    public ResponseEntity<List<Funcionario>> listarFuncionarios() {
        List<Funcionario> funcionarios = funcionarioServ.listarFuncionarios();
        return ResponseEntity.ok(funcionarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscarFuncionarioId(@PathVariable Long id) {
        try {
            Funcionario funcionario = funcionarioServ.buscarFuncionarioPorId(id);
            return ResponseEntity.ok(funcionario);
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

