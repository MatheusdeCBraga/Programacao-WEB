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
import org.springframework.web.bind.annotation.RestController;

import br.edu.iff.bsi.Pizzaria.service.IngredienteService;
import br.edu.iff.bsi.Pizzaria.entities.*;

@RestController
@RequestMapping("/api/v1/ingrediente")
public class IngredienteRestController {

    @Autowired
    private IngredienteService ingredienteService;

    @PostMapping("")
    public ResponseEntity<Ingrediente> addIngrediente(@RequestBody Ingrediente ingrediente) {
        ingredienteService.salvarIngrediente(ingrediente);
        return ResponseEntity.status(HttpStatus.CREATED).body(ingrediente);
    }

    @GetMapping("")
    public ResponseEntity<List<Ingrediente>> listarIngredientes() {
        List<Ingrediente> ingredientes = ingredienteService.listarIngredientes();
        return ResponseEntity.ok(ingredientes);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Ingrediente> buscarIngredienteId(@PathVariable Long id) {
        try {
            Ingrediente ingrediente = ingredienteService.buscarIngredientePorId(id);
            return ResponseEntity.ok(ingrediente);
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Ingrediente> atualizarIngrediente(@PathVariable Long id, @RequestBody Ingrediente ingredienteAtualizado) throws NotFoundException {
        Ingrediente ingrediente = ingredienteService.buscarIngredientePorId(id);
        ingrediente.setNome(ingredienteAtualizado.getNome());
        ingrediente.setQuantidadeEstoque(ingredienteAtualizado.getQuantidadeEstoque());
        ingrediente.setPreco(ingredienteAtualizado.getPreco());

        ingredienteService.atualizarIngrediente(ingrediente);
        return ResponseEntity.ok(ingrediente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirIngrediente(@PathVariable Long id) {
        ingredienteService.removerIngrediente(id);
        return ResponseEntity.noContent().build();
    }
}
