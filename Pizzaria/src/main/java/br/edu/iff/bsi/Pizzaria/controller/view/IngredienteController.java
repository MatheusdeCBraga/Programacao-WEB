package br.edu.iff.bsi.Pizzaria.controller.view;

import java.util.List;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.iff.bsi.Pizzaria.service.IngredienteService;
import br.edu.iff.bsi.Pizzaria.entities.*;
import br.edu.iff.bsi.Pizzaria.repository.IngredienteRepository;

@Controller
@RequestMapping("/ingrediente")
public class IngredienteController {

    @Autowired
    private IngredienteService ingredienteService;

    @GetMapping("/cadastro")
    public String showCadastroIngredienteForm(Model model) {
        model.addAttribute("ingrediente", new Ingrediente());
        return "ingrediente";
    }

    @PostMapping("/saveIngrediente")
    public String registerIngrediente(@ModelAttribute Ingrediente ingrediente) {
        ingredienteService.salvarIngrediente(ingrediente);
        return "redirect:/ingrediente/listar";
    }

    @GetMapping("/listar")
    public String listarIngredientes(Model model) {
        List<Ingrediente> ingredientes = ingredienteService.listarIngredientes();
        model.addAttribute("ingredientes", ingredientes);
        return "listaIngredientes";
    }

    @GetMapping("/editar")
    public String editarIngrediente(@RequestParam Long id, Model model) throws NotFoundException {
        Ingrediente ingrediente = ingredienteService.buscarIngredientePorId(id);
        model.addAttribute("ingrediente", ingrediente); 
        return "editarIngrediente";
    }

    @PostMapping("/atualizar")
    public String atualizarIngrediente(@ModelAttribute Ingrediente ingrediente) {
        ingredienteService.atualizarIngrediente(ingrediente);
        return "redirect:/ingrediente/listar";
    }

    @GetMapping("/excluir")
    public String excluirIngrediente(@RequestParam Long id) {
        ingredienteService.removerIngrediente(id);
        return "redirect:/ingrediente/listar";
    }
}

	
