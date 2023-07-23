package br.edu.iff.bsi.Pizzaria.controller.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.iff.bsi.Pizzaria.service.IngredienteService;
import br.edu.iff.bsi.Pizzaria.entities.*;

@Controller
public class IngredienteController {

    private final IngredienteService ingredienteService;

    @Autowired
    public IngredienteController(IngredienteService ingredienteService) {
        this.ingredienteService = ingredienteService;
    }

    

    @GetMapping("/adicionar-ingrediente")
    public String exibirFormularioAdicionarIngrediente(Model model) {
        // Cria um objeto Ingrediente vazio para ser preenchido no formulário
        Ingrediente ingrediente = new Ingrediente(null, null, 0, 0);

        // Adiciona o objeto ao modelo para ser usado na view
        model.addAttribute("ingrediente", ingrediente);

        // Retorna o nome da view (HTML) do formulário de adição de ingrediente
        return "adicionar-ingrediente";
    }

    @PostMapping("/adicionar-ingrediente")
    public String adicionarIngrediente(@ModelAttribute Ingrediente ingrediente) {
        // Salva o ingrediente usando o serviço
        ingredienteService.addIngrediente(ingrediente);

        // Redireciona para a lista de ingredientes após a adição
        return "redirect:/ingredientes";
    }
}