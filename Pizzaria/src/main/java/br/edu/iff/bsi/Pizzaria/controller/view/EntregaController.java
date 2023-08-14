package br.edu.iff.bsi.Pizzaria.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;


import java.util.List;

import br.edu.iff.bsi.Pizzaria.entities.Entrega;
import br.edu.iff.bsi.Pizzaria.service.EntregaService;


@Controller
@RequestMapping("/entrega")
public class EntregaController {

    @Autowired
    private EntregaService entregaService;

    @GetMapping("/cadastro")
    public String showCadastroEntregaForm(Model model) {
        model.addAttribute("entrega", new Entrega());
        return "entrega";
    }

    @PostMapping("/saveEntrega")
    public String registerEntrega(@ModelAttribute Entrega entrega) {
        entregaService.salvarEntrega(entrega);
        return "redirect:/entrega/listar";
    }

    @GetMapping("/listar")
    public String listarEntregas(Model model) {
        List<Entrega> entregas = entregaService.listarEntregas();
        model.addAttribute("entregas", entregas);
        return "listaEntregas";
    }

    @GetMapping("/editar")
    public String editarEntrega(@RequestParam Long id, Model model) throws NotFoundException {
        Entrega entrega = entregaService.buscarEntregaPorId(id);
        model.addAttribute("entrega", entrega); 
        return "editarEntrega";
    }

    @PostMapping("/atualizar")
    public String atualizarEntrega(@ModelAttribute Entrega entrega) {
        entregaService.atualizarEntrega(entrega);
        return "redirect:/entrega/listar";
    }

    @GetMapping("/excluir")
    public String excluirEntrega(@RequestParam Long id) {
        entregaService.removerEntrega(id);
        return "redirect:/entrega/listar";
    }
}

