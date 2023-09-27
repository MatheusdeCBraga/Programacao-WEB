package br.edu.iff.bsi.Pizzaria.controller.apirest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.edu.iff.bsi.Pizzaria.entities.Pizza;
import br.edu.iff.bsi.Pizzaria.service.PizzaService;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

//@RestController
//@RequestMapping("/api/v1/pizzas")
//public class PizzaRestController {
//
//    @Autowired
//    private PizzaService pizzaService;
//
//    @GetMapping
//    @ResponseBody
//	@Operation(summary = "Listar todas as pizzas")
//    public List<Pizza> getAllPizzas() {
//        return pizzaService.getAllPizzas();
//    }
//
//    @GetMapping("/{id}")
//    @ResponseBody
//	@Operation(summary = "Retornar uma pizza em especifíco")
//    public Pizza getPizzaById(@PathVariable Long id) {
//        return pizzaService.getPizzaById(id);
//    }
//
//    @PostMapping
//    @ResponseBody
//	@Operation(summary = "Adicionar uma nova pizza")
//    public Pizza createPizza(@RequestBody Pizza pizza) {
//        return pizzaService.createPizza(pizza);
//    }
//
//    @PutMapping("/{id}")
//    @ResponseBody
//	@Operation(summary = "Atualizar uma pizza em especifíco")
//    public Pizza updatePizza(@PathVariable Long id, @RequestBody Pizza pizza) {
//        return pizzaService.updatePizza(id, pizza);
//    }
//
//    @DeleteMapping("/{id}")
//    @ResponseBody
//	@Operation(summary = "Remover uma pizza em especifíco")
//    public void deletePizza(@PathVariable Long id) {
//        pizzaService.deletePizza(id);
//    }

