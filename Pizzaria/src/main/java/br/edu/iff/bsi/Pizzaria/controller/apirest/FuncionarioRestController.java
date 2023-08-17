package br.edu.iff.bsi.Pizzaria.controller.apirest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.edu.iff.bsi.Pizzaria.entities.Funcionario;
import br.edu.iff.bsi.Pizzaria.service.FuncionarioService;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@RestController
@RequestMapping("/api/v1/funcionarios")
public class FuncionarioRestController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    @ResponseBody
	@Operation(summary = "Listar todos os funcionarios")
    public List<Funcionario> getAllFuncionarios() {
        return funcionarioService.getAllFuncionarios();
    }

    @GetMapping("/{id}")
    @ResponseBody
	@Operation(summary = "Retornar Funcionario especifico")
    public Funcionario getFuncionarioById(@PathVariable Long id) {
        return funcionarioService.getFuncionarioById(id);
    }

    @PostMapping
    @ResponseBody
	@Operation(summary = "Adicionar um novo funcioanrio")
    public Funcionario createFuncionario(@RequestBody Funcionario funcionario) {
        return funcionarioService.createFuncionario(funcionario);
    }

    @PutMapping("/{id}")
    @ResponseBody
	@Operation(summary = "Atualizar dados de um funcionario em especifico")
    public Funcionario updateFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionario) {
        return funcionarioService.updateFuncionario(id, funcionario);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
	@Operation(summary = "Remover um funcioanrio")
    public void deleteFuncionario(@PathVariable Long id) {
        funcionarioService.deleteFuncionario(id);
    }
}
