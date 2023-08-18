package br.edu.iff.bsi.Pizzaria.controller.apirest;


import java.util.List;
import java.util.stream.Collectors;

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

import br.edu.iff.bsi.Pizzaria.entities.Ingrediente;
import br.edu.iff.bsi.Pizzaria.entities.Pizza;
import br.edu.iff.bsi.Pizzaria.service.IngredienteService;
import br.edu.iff.bsi.Pizzaria.service.PizzaService;

@RestController
@RequestMapping("/api/v1/pizza")
public class PizzaRestController {

	@Autowired
	private PizzaService pizzaService;

	@Autowired
	private IngredienteService ingredienteService;

	@PostMapping("")
	public ResponseEntity<Pizza> addPizza(@RequestBody Pizza pizza) {
	    List<Ingrediente> selectedIngredientes = ingredienteService.buscarIngredientesPorIds(pizza.getIngredientes().stream().map(Ingrediente::getId).collect(Collectors.toList()));
	    pizza.setIngredientes(selectedIngredientes);

	    pizzaService.salvarPizza(pizza);
	    return ResponseEntity.status(HttpStatus.CREATED).body(pizza);
	}

	@GetMapping("")
	public ResponseEntity<List<Pizza>> listarPizzas() {
	    List<Pizza> pizzas = pizzaService.listarPizzasComIngredientes();
	    return ResponseEntity.ok(pizzas);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Pizza> atualizarPizza(@PathVariable Long id, @RequestBody Pizza pizzaAtualizada) throws NotFoundException {
		Pizza pizza = pizzaService.buscarPizzaPorId(id);
        List<Ingrediente> ingredientes = ingredienteService.buscarIngredientesPorIds(pizzaAtualizada.getIngredientes().stream().map(Ingrediente::getId).collect(Collectors.toList()));
        pizza.setIngredientes(ingredientes);
        pizza.setSabor(pizzaAtualizada.getSabor());
        pizza.setTamanho(pizzaAtualizada.getTamanho());
        pizza.setPreco(pizzaAtualizada.getPreco());

        pizzaService.atualizarPizza(pizza);
        return ResponseEntity.ok(pizza);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluirPizza(@PathVariable Long id) {
		pizzaService.removerPizza(id);
		return ResponseEntity.noContent().build();
	}


	@GetMapping("/{id}")
	public ResponseEntity<Pizza> buscarPizzaId(@PathVariable Long id) {
	    try {
	        Pizza pizza = pizzaService.buscarPizzaPorId(id);
	        return ResponseEntity.ok(pizza);
	    } catch (NotFoundException e) {
	        return ResponseEntity.notFound().build();
	    }
	}

}

