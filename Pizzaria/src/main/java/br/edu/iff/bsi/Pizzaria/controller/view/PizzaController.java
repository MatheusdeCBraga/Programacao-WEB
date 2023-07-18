package br.edu.iff.bsi.Pizzaria.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.iff.bsi.Pizzaria.entities.Pizza;

@Controller
@RequestMapping(path = "/pizza")
public class PizzaController {

		    @GetMapping("/cadastro")
		    public String showCadastroPizzaForm() {
		        return "pizza";
		    }
			
			@PostMapping("/savepizza")
			public String registerPizza(@ModelAttribute Pizza pizza) {
				System.out.println("ID da Pizza: " + pizza.getId());
				System.out.println("Item da Pizza: " + pizza.getItempedido());
				System.out.println("Preco da Pizza: " + pizza.getPreco());
				System.out.println("Sabor da Pizza " + pizza.getSabor());
				System.out.println("Tamanho da Pizza"+ pizza.getTamanho());
				return "sucesso";
			}

		}

