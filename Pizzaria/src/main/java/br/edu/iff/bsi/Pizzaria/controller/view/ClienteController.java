//package br.edu.iff.bsi.Pizzaria.controller.view;
//
//import java.util.Arrays;
//import java.util.List;
//import org.springframework.ui.Model;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import br.edu.iff.bsi.Pizzaria.entities.*;
//import br.edu.iff.bsi.Pizzaria.repository.*;
//import br.edu.iff.bsi.Pizzaria.service.*;
//
//
////@Controller
////@RequestMapping("/cliente")
////public class ClienteController {
////
////    @Autowired
////    private ClienteService clienteService;
////
////    @GetMapping("/cadastro")
////    public String showCadastroClienteForm(Model model) {
////        model.addAttribute("cliente", new Cliente());
////        return "cliente";
////    }
////
////    @PostMapping("/saveCliente")
////    public String registerCliente(@ModelAttribute Cliente cliente) {
////        clienteService.salvarCliente(cliente);
////        return "redirect:/cliente/listar";
////    }
////
////    @GetMapping("/listar")
////    public String listarClientes(Model model) {
////        List<Cliente> clientes = clienteService.listarClientes();
////        model.addAttribute("clientes", clientes);
////        return "listaClientes";
////    }
////
////    @GetMapping("/editar")
////    public String editarCliente(@RequestParam Long id, Model model) throws NotFoundException {
////        Cliente cliente = clienteService.buscarClientePorId(id);
////        model.addAttribute("cliente", cliente); 
////        return "editarCliente";
////    }
////
////    @PostMapping("/atualizar")
////    public String atualizarCliente(@ModelAttribute Cliente cliente) {
////        clienteService.atualizarCliente(cliente);
////        return "redirect:/cliente/listar";
////    }
////
////    @GetMapping("/excluir")
////    public String excluirCliente(@RequestParam Long id) {
////        clienteService.removerCliente(id);
////        return "redirect:/cliente/listar";
////    }
//}
//
