package br.edu.iff.bsi.Pizzaria.controller.view;

import java.util.List;
import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import br.edu.iff.bsi.Pizzaria.entities.Funcionario;
import br.edu.iff.bsi.Pizzaria.service.*;

@Controller
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping("/cadastro")
    public String showCadastroFuncionarioForm(Model model) {
        model.addAttribute("funcionario", new Funcionario());
        return "funcionario";
    }

    @PostMapping("/saveFuncionario")
    public String registerFuncionario(@ModelAttribute Funcionario funcionario) {
        funcionarioService.salvarFuncionario(funcionario);
        return "redirect:/funcionario/listar";
    }

    @GetMapping("/listar")
    public String listarFuncionarios(Model model) {
        List<Funcionario> funcionarios = funcionarioService.listarFuncionarios();
        model.addAttribute("funcionarios", funcionarios);
        return "listaFuncionarios";
    }

    @GetMapping("/editar")
    public String editarFuncionario(@RequestParam Long id, Model model) throws NotFoundException {
        Funcionario funcionario = funcionarioService.buscarFuncionarioPorId(id);
        model.addAttribute("funcionario", funcionario); 
        return "editarFuncionario";
    }

    @PostMapping("/atualizar")
    public String atualizarFuncionario(@ModelAttribute Funcionario funcionario) {
        funcionarioService.atualizarFuncionario(funcionario);
        return "redirect:/funcionario/listar";
    }

    @GetMapping("/excluir")
    public String excluirFuncionario(@RequestParam Long id) {
        funcionarioService.removerFuncionario(id);
        return "redirect:/funcionario/listar";
    }
}

