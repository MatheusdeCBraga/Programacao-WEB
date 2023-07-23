package br.edu.iff.bsi.Pizzaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iff.bsi.Pizzaria.entities.*;
import br.edu.iff.bsi.Pizzaria.repository.*;

@Service
public class PizzaService {
	@Autowired
	PizzaRepository PizzaRep;

	public Pizza salvarPizza(Pizza pizza) {
		return PizzaRep.save(pizza);
	}

	public List<Pizza> listarPizzas() {
		return PizzaRep.findAll();
	}

	public Pizza atualizarPizza(Pizza pizza) {
		if (pizza.getId() != null) {
			return PizzaRep.save(pizza);
		} else {
			throw new RuntimeException("Pizza inexistente no Banco de Dados. Favor adicionar essa Pizza");
		}
	}

	public void removerPizza(Long PizzaId) {
		PizzaRep.deleteById(PizzaId);
	}
	
	public Pizza buscarPizzaPorId(Long id) {
        return PizzaRep.findById(id).orElse(null);
    }

}
