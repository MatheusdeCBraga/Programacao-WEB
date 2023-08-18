package br.edu.iff.bsi.Pizzaria.controller.view;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.LinkedHashMap;
import java.util.HashMap;

import br.edu.iff.bsi.Pizzaria.entities.*;
import br.edu.iff.bsi.Pizzaria.service.*;

@Controller
@RequestMapping("/itempedido")
public class ItemPedidoController {

	@Autowired
	private ItemPedidoService itemPedidoService;

	@Autowired
	private PizzaService pizzaService;

	private Map<Long, ItemPedido> selectedItemPedidos = new HashMap<>();

	@GetMapping("/cadastro")
	public String showCadastroItemPedidoForm(Model model) {
		model.addAttribute("itempedido", new ItemPedido());
		List<Pizza> pizzas = pizzaService.listarPizzas();

		model.addAttribute("pizzas", pizzas);
		return "itempedido";
	}

	@PostMapping("/saveItem")
	public String registerItemPedido(@ModelAttribute ItemPedido itemPedido,
			@RequestParam("selectedPizza") Long selectedPizzaId) throws NotFoundException {
		Pizza selectedPizza = pizzaService.buscarPizzaPorId(selectedPizzaId);
		itemPedido.setPizza(selectedPizza);

		itemPedidoService.salvarItemPedido(itemPedido);

		selectedItemPedidos.put(itemPedido.getId(), itemPedido);
		return "redirect:/itempedido/listar";
	}

	@ModelAttribute("selectedItemPedidos")
	public Map<Long, ItemPedido> getSelectedItemPedidos() {
		return selectedItemPedidos;
	}

	@GetMapping("/listar")
	public String listarItemPedidos(Model model) {
		List<ItemPedido> itemPedidos = itemPedidoService.listarItemPedidosComPizzas();
		List<Object[]> formattedItemPedidos = new ArrayList<>();

		for (ItemPedido itemPedido : itemPedidos) {
			Object[] formattedItem = new Object[3]; 

			formattedItem[0] = itemPedido.getId();
			formattedItem[1] = itemPedido.getQuantidade_de_itens();

			Pizza pizza = itemPedido.getPizza();
			if (pizza != null) {
				formattedItem[2] = pizza.getSabor();
			} else {
				formattedItem[2] = "N/A"; 
			}

			formattedItemPedidos.add(formattedItem);
		}

		model.addAttribute("itempedidos", formattedItemPedidos);
		return "listaItemPedidos";
	}

	
	@GetMapping("/editar")
	public String exibirFormularioEdicao(@RequestParam Long id, Model model) throws NotFoundException {
	    ItemPedido item = itemPedidoService.buscarItemPorId(id);
	    List<Pizza> pizzas = pizzaService.listarPizzas();
	    
	    model.addAttribute("item", item);
	    model.addAttribute("pizzas", pizzas);
	    
	    return "editarItem";
	}




	@PostMapping("/atualizar")
	public String atualizarItem(@ModelAttribute ItemPedido item) throws NotFoundException {
	    itemPedidoService.atualizarItem(item);
	    return "redirect:/itempedido/listar";
	}


	@GetMapping("/excluir")
	public String excluirItem(@RequestParam Long id) {
		itemPedidoService.removerItem(id);
		return "redirect:/itempedido/listar";
	}

}
