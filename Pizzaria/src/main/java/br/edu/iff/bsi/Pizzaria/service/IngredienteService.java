package br.edu.iff.bsi.Pizzaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iff.bsi.Pizzaria.controller.view.IngredienteController;
import br.edu.iff.bsi.Pizzaria.entities.*;
import br.edu.iff.bsi.Pizzaria.repository.*;

@Service
public class IngredienteService {
	@Autowired
	private IngredienteRepository ingredienteRepository;
	
	public Ingrediente addIngrediente(Ingrediente ingrediente) {
		return ingredienteRepository.save(ingrediente);
	}

	public List<Ingrediente> getAllIngredientes() {
        return ingredienteRepository.findAll();
    }
	}



