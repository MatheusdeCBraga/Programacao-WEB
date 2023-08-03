package br.edu.iff.bsi.Pizzaria.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.edu.iff.bsi.Pizzaria.entities.Pizza;
import br.edu.iff.bsi.Pizzaria.service.PizzaService;
import ch.qos.logback.core.model.Model;

@Controller
@RequestMapping("/pizzas")
public class PizzaController {

	 private final PizzaService pizzaService;

	    @Autowired
	    public PizzaController(PizzaService pizzaService) {
	        this.pizzaService = pizzaService;
	    }

	    @GetMapping
	    public ModelAndView listarPizzas() {
	        ModelAndView modelAndView = new ModelAndView("lista-pizzas");
	        modelAndView.addObject("pizzas", pizzaService.listarPizzas());
	        return modelAndView;
	    }

	    @GetMapping("/adicionar")
	    public ModelAndView exibirFormularioAdicionarPizza() {
	        ModelAndView modelAndView = new ModelAndView("adicionar-pizza");
	        modelAndView.addObject("pizza", new Pizza());
	        return modelAndView;
	    }

	    @PostMapping("/adicionar")
	    public String adicionarPizza(@ModelAttribute Pizza pizza) {
	        pizzaService.salvarPizza(pizza);
	        return "redirect:/pizzas";
	    }

	    @GetMapping("/editar")
	    public ModelAndView exibirFormularioEditarPizza(@RequestParam Long id) {
	        Pizza pizza = pizzaService.buscarPizzaPorId(id);
	        if (pizza == null) {
	            return new ModelAndView("redirect:/pizzas");
	        }
	        ModelAndView modelAndView = new ModelAndView("editar-pizza");
	        modelAndView.addObject("pizzaObj", pizza);
	        return modelAndView;
	    }

	    @PostMapping("/editar")
	    public String editarPizza(@ModelAttribute Pizza pizza) {
	        pizzaService.atualizarPizza(pizza);
	        return "redirect:/pizzas";
	    }

	    @GetMapping("/remover")
	    public String removerPizza(@RequestParam Long id) {
	        pizzaService.removerPizza(id);
	        return "redirect:/pizzas";
	    }
	}

