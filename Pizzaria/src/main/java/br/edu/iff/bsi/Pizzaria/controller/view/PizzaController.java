//package br.edu.iff.bsi.Pizzaria.controller.view;
//
//import java.util.List;
//
//import java.util.Map;
//import java.util.LinkedHashMap;
//import java.util.HashMap;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.ui.Model;
//
//import br.edu.iff.bsi.Pizzaria.entities.Ingrediente;
//import br.edu.iff.bsi.Pizzaria.entities.Pizza;
//import br.edu.iff.bsi.Pizzaria.service.IngredienteService;
//import br.edu.iff.bsi.Pizzaria.service.PizzaService;
//
//@Controller
//@RequestMapping("/pizza")
//public class PizzaController {
//
//	@Autowired
//	private PizzaService pizzaService;
//
//	@Autowired
//	private IngredienteService ingredienteService;
//
//	private Map<Long, Pizza> selectedPizzas = new HashMap<>();
//	private static final Logger logger = LoggerFactory.getLogger(PizzaController.class);
//
////	@GetMapping("/cadastro")
////	public String showCadastroPizzaForm(Model model) {
////		model.addAttribute("pizza", new Pizza());
////		List<Ingrediente> ingredientes = ingredienteService.listarIngredientes();
////		model.addAttribute("ingredientes", ingredientes);
////		return "pizza";
////	}
//
//	@PostMapping("/savePizza")
//	public String registerPizza(@ModelAttribute Pizza pizza,
//			@RequestParam("selectedIngredients") List<Long> selectedIngredientsIds) {
//		List<Ingrediente> selectedIngredientes = ingredienteService.buscarIngredientesPorIds(selectedIngredientsIds);
//		pizza.setIngredientes(selectedIngredientes);
//
//		pizzaService.salvarPizza(pizza);
//
//		selectedPizzas.put(pizza.getId(), pizza);
//		return "redirect:/pizza/listar";
//	}
//
//	@ModelAttribute("sabores")
//	public Map<Long, String> getSaboresMap() {
//		List<Pizza> pizzas = pizzaService.listarPizzasComIngredientes();
//		Map<Long, String> saboresMap = new LinkedHashMap<>();
//
//		for (Pizza pizza : pizzas) {
//			saboresMap.put(pizza.getId(), pizza.getSabor());
//		}
//
//		return saboresMap;
//	}
//
//	@ModelAttribute("selectedPizzas") //
//	public Map<Long, Pizza> getSelectedPizzas() {
//		return selectedPizzas;
//	}
//
//	@GetMapping("/listar")
//	public String listarPizzas(Model model) {
//		List<Pizza> pizzas = pizzaService.listarPizzasComIngredientes();
//		Map<Long, Pizza> pizzaMap = new LinkedHashMap<>();
//
//		for (Pizza pizza : pizzas) {
//			pizzaMap.put(pizza.getId(), pizza);
//		}
//
//		model.addAttribute("pizzas", pizzaMap.values());
//		return "listaPizzas";
//	}
//
//	@GetMapping("/editar")
//	public String editarPizza(@RequestParam Long id, Model model) throws NotFoundException {
//		Pizza pizza = pizzaService.buscarPizzaPorId(id);
//		List<Ingrediente> ingredientes = ingredienteService.listarIngredientes();
//
//		model.addAttribute("pizza", pizza);
//		model.addAttribute("ingredientes", ingredientes);
//
//		return "editarPizza";
//
//	}
//
//	@PostMapping("/atualizar")
//	public String atualizarPizza(@ModelAttribute Pizza pizza) {
//		pizzaService.atualizarPizza1(pizza);
//		return "redirect:/pizza/listar";
//	}
//
//	@GetMapping("/excluir")
//	public String excluirPizza(@RequestParam Long id) {
//		pizzaService.removerPizza(id);
//		return "redirect:/pizza/listar";
//	}
//	
//	
//}