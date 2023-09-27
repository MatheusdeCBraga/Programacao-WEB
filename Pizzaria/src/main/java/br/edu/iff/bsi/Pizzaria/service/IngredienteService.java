package br.edu.iff.bsi.Pizzaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import br.edu.iff.bsi.Pizzaria.entities.Ingrediente;
import br.edu.iff.bsi.Pizzaria.repository.IngredienteRepository;

import java.util.List;

@Service
public class IngredienteService {

    @Autowired
    private IngredienteRepository ingredienteRepository;

    public void salvarIngrediente(Ingrediente ingrediente) {
        ingredienteRepository.save(ingrediente);
    }

    public List<Ingrediente> listarIngredientes() {
        return ingredienteRepository.findAll();
    }

    public Ingrediente buscarIngredientePorId(Long id) throws NotFoundException {
        return ingredienteRepository.findById(id).orElseThrow(() -> new NotFoundException());
    }

    public void atualizarIngrediente(Ingrediente ingrediente) {
        ingredienteRepository.save(ingrediente);
    }

    public void removerIngrediente(Long id) {
        ingredienteRepository.deleteById(id);
    }
    public List<Ingrediente> buscarIngredientesPorIds(List<Long> ids) {
        return ingredienteRepository.findAllById(ids);
    }

}
