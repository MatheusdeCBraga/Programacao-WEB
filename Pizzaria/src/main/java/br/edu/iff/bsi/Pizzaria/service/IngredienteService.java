package br.edu.iff.bsi.Pizzaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import br.edu.iff.bsi.Pizzaria.controller.view.IngredienteController;
import br.edu.iff.bsi.Pizzaria.entities.*;
import br.edu.iff.bsi.Pizzaria.repository.*;

@Service
public class IngredienteService {

    @Autowired
    private IngredienteRepository ingredienteRepository;

    public Ingrediente salvarIngrediente(Ingrediente ingrediente) {
        return ingredienteRepository.save(ingrediente);
    }

    public List<Ingrediente> listarIngredientes() {
        return ingredienteRepository.findAll();
    }

    public Ingrediente buscarIngredientePorId(Long id) throws NotFoundException {
        return ingredienteRepository.findById(id)
            .orElseThrow(() -> new NotFoundException());
    }
    public List<Ingrediente> buscarIngredientesPorIds(List<Long> ids) {
        return ingredienteRepository.findByIdIn(ids);
    }

    public void atualizarIngrediente(Ingrediente ingrediente) {
        ingredienteRepository.save(ingrediente);
    }

    public void removerIngrediente(Long id) {
        ingredienteRepository.deleteById(id);
    }
    
}



