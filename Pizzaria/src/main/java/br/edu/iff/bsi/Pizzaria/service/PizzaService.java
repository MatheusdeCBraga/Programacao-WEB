package br.edu.iff.bsi.Pizzaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iff.bsi.Pizzaria.entities.Pizza;
import br.edu.iff.bsi.Pizzaria.repository.PizzaRepository;

import java.util.List;

@Service
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    public List<Pizza> getAllPizzas() {
        return pizzaRepository.findAll();
    }

    public Pizza getPizzaById(Long id) {
        return pizzaRepository.findById(id).orElse(null);
    }

    public Pizza createPizza(Pizza pizza) {
        return pizzaRepository.save(pizza);
    }

    public Pizza updatePizza(Long id, Pizza pizza) {
        if (pizzaRepository.existsById(id)) {
            pizza.setId(id);
            return pizzaRepository.save(pizza);
        }
        return null;
    }

    public void deletePizza(Long id) {
        pizzaRepository.deleteById(id);
    }
}
