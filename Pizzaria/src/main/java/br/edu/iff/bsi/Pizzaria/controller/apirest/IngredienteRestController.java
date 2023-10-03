package br.edu.iff.bsi.Pizzaria.controller.apirest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.edu.iff.bsi.Pizzaria.entities.Ingrediente;
import br.edu.iff.bsi.Pizzaria.repository.IngredienteRepository;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ingredientes")
public class IngredienteRestController {

    @Autowired
    private IngredienteRepository ingredienteRepository;

    @GetMapping
    @ResponseBody
	@Operation(summary = "Listar todos os clientes")
    public List<Ingrediente> getAllIngredientes() {
        return ingredienteRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
	@Operation(summary = "Retornar um ingrediente em especifíco")
    public Ingrediente getIngredienteById(@PathVariable Long id) {
        return ingredienteRepository.findById(id).orElse(null);
    }

    @PostMapping
    @ResponseBody
	@Operation(summary = "Adiconar um ingrediente em especifíco")
    public Ingrediente createIngrediente(@RequestBody Ingrediente ingrediente) {
        return ingredienteRepository.save(ingrediente);
    }

    @PutMapping("/{id}")
    @ResponseBody
	@Operation(summary = "Atualizar um ingrediente em especifíco")
    public Ingrediente updateIngrediente(@PathVariable Long id, @RequestBody Ingrediente ingrediente) {
        if (ingredienteRepository.existsById(id)) {
            ingrediente.setId(id);
            return ingredienteRepository.save(ingrediente);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    @ResponseBody
	@Operation(summary = "Remover um ingrediente em especifíco")
    public void deleteIngrediente(@PathVariable Long id) {
        ingredienteRepository.deleteById(id);
    }
}
