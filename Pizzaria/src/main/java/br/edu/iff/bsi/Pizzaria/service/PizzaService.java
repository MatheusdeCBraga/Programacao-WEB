package br.edu.iff.bsi.Pizzaria.service;

import java.util.List;
import java.util.stream.Collectors;
import br.edu.iff.bsi.Pizzaria.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import br.edu.iff.bsi.Pizzaria.entities.*;
import br.edu.iff.bsi.Pizzaria.repository.*;
import jakarta.transaction.Transactional;

@Service
public class PizzaService {

	@Autowired
	private PizzaRepository pizzaRepository;

	@Transactional
	public void salvarPizza(Pizza pizza) {
		pizzaRepository.save(pizza);
	}

	public List<Pizza> listarPizzas() {
		return pizzaRepository.findAll();
	}

	public Pizza buscarPizzaPorId(Long id) throws NotFoundException {
		return pizzaRepository.findById(id).orElseThrow(() -> new NotFoundException());
	}
	public List<Pizza> buscarPizzasPorIds(List<Long> ids) {
	    return pizzaRepository.findAllById(ids);
	}


	public void atualizarPizza(Pizza pizza) {
		pizzaRepository.save(pizza);
	}

	public void removerPizza(Long id) {
		pizzaRepository.deleteById(id);
	}

	@Transactional
	public List<Pizza> listarPizzasComIngredientes() {
		List<Pizza> pizzas = pizzaRepository.findAll();
	    System.out.println(pizzas);
	    return pizzas;
    }

	public List<String> listarSaboresPizza() {
        List<Pizza> pizzas = pizzaRepository.findAll();
        List<String> saboresPizza = pizzas.stream()
            .map(Pizza::getSabor)
            .collect(Collectors.toList());
        return saboresPizza;
    }
	
	
	
	

}
	
	
	

