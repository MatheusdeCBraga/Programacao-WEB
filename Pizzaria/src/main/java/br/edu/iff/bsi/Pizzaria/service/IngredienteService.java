package br.edu.iff.bsi.Pizzaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iff.bsi.Pizzaria.entities.Ingrediente;
import br.edu.iff.bsi.Pizzaria.repository.IngredienteRepository;

import java.util.List;

@Service
public class IngredienteService {

    @Autowired
    private IngredienteRepository ingredienteRepository;

    public List<Ingrediente> getAllIngredientes() {
        return ingredienteRepository.findAll();
    }

    public Ingrediente getIngredienteById(Long id) {
        return ingredienteRepository.findById(id).orElse(null);
    }

    public Ingrediente createIngrediente(Ingrediente ingrediente) {
        return ingredienteRepository.save(ingrediente);
    }

    public Ingrediente updateIngrediente(Long id, Ingrediente ingrediente) {
        if (ingredienteRepository.existsById(id)) {
            ingrediente.setId(id);
            return ingredienteRepository.save(ingrediente);
        }
        return null;
    }

    public void deleteIngrediente(Long id) {
        ingredienteRepository.deleteById(id);
    }
}
