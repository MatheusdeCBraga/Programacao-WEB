package br.edu.iff.bsi.Pizzaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import br.edu.iff.bsi.Pizzaria.entities.Ingrediente;
import br.edu.iff.bsi.Pizzaria.entities.Pizza;
import br.edu.iff.bsi.Pizzaria.repository.PizzaRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {

	@Autowired
	private PizzaRepository pizzaRepository;

	public void salvarPizza(Pizza pizza) {
		pizzaRepository.save(pizza);
	}

	public List<Pizza> listarPizzasComIngredientes() {
		return pizzaRepository.findAll();
	}

	public Pizza buscarPizzaPorId(Long id) throws NotFoundException {
		return pizzaRepository.findById(id).orElseThrow(() -> new NotFoundException());
	}

	public Pizza atualizarPizza(Pizza pizzaAtualizada) throws NotFoundException {
		Optional<Pizza> pizzaOptional = pizzaRepository.findById(pizzaAtualizada.getId());

		if (!pizzaOptional.isPresent()) {
			throw new NotFoundException();
		}

		Pizza pizzaExistente = pizzaOptional.get();

		pizzaExistente.setTamanhoDaPizza(pizzaAtualizada.getTamanhoDaPizza());
		pizzaExistente.setSabor(pizzaAtualizada.getSabor());
		pizzaExistente.setPreco(pizzaAtualizada.getPreco());
		pizzaExistente.setIngredientes(pizzaAtualizada.getIngredientes());

		return pizzaRepository.save(pizzaExistente);
	}

	public void removerPizza(Long id) {
		pizzaRepository.deleteById(id);
	}

	public List<Pizza> buscarPizzaPorIds(List<Long> ids) {
		return pizzaRepository.findAllById(ids);
	}
}
