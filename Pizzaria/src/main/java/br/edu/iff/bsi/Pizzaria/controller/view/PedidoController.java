package br.edu.iff.bsi.Pizzaria.controller.view;

import br.edu.iff.bsi.Pizzaria.entities.Cliente;
import br.edu.iff.bsi.Pizzaria.entities.Funcionario;
import br.edu.iff.bsi.Pizzaria.entities.Ingrediente;
import br.edu.iff.bsi.Pizzaria.entities.ItemPedido;
import br.edu.iff.bsi.Pizzaria.entities.Pedido;
import br.edu.iff.bsi.Pizzaria.entities.Pizza;
import br.edu.iff.bsi.Pizzaria.repository.PizzaRepository;
import br.edu.iff.bsi.Pizzaria.entities.Pedido;
import br.edu.iff.bsi.Pizzaria.service.PedidoService;
import br.edu.iff.bsi.Pizzaria.service.PizzaService;
import br.edu.iff.bsi.Pizzaria.service.ClienteService;
import br.edu.iff.bsi.Pizzaria.service.FuncionarioService;
import br.edu.iff.bsi.Pizzaria.service.PedidoService;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Enumeration;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;

	@Autowired
	private PizzaService pizzaService;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private FuncionarioService funcionarioService;

	@Autowired
	private PizzaRepository pizzaRepository;

	@GetMapping("/cadastro")
	public String showCadastroPedidoForm(Model model) {
	    model.addAttribute("pedido", new Pedido());
	    
	    List<Pizza> pizzas = pizzaService.listarPizzasComIngredientes();
	    model.addAttribute("pizzas", pizzas);
	    
	    List<Cliente> clientes = clienteService.getAllClientes(); // Busca a lista de clientes
	    model.addAttribute("clientes", clientes); // Adiciona a lista de clientes ao modelo
	    
	    List<Funcionario> funcionarios = funcionarioService.getAllFuncionarios(); // Busca a lista de funcionários
	    model.addAttribute("funcionarios", funcionarios); // Adiciona a lista de funcionários ao modelo

	    return "pedido";
	}


	@PostMapping("/savePedido")
	public String registerPedido(@ModelAttribute Pedido pedido,
	        @RequestParam("selectedPizzas") List<Long> selectedPizzasIds,
	        @RequestParam("selectedCliente") Long selectedClienteId,
	        @RequestParam("selectedFuncionario") Long selectedFuncionarioId) throws NotFoundException {
		List<Pizza> selectedPizzas = pizzaService.buscarPizzaPorIds(selectedPizzasIds);
		pedido.setPizza(selectedPizzas);

	    Cliente selectedCliente = clienteService.getClienteById(selectedClienteId);
	    pedido.setCliente(selectedCliente);

	    Funcionario selectedFuncionario = funcionarioService.getFuncionarioById(selectedFuncionarioId);
	    pedido.setFuncionario(selectedFuncionario);

	    pedidoService.salvarPedido(pedido, selectedPizzasIds, selectedClienteId, selectedFuncionarioId);


	    return "redirect:/pedido/listar";
	}


	@GetMapping("/listar")
	public String listarPedidos(Model model) {
		List<Pedido> pedidos = pedidoService.listarPedidos();
		model.addAttribute("pedidos", pedidos);
		return "listaPedidos";
	}

	@GetMapping("/editar")
	public String editarPedido(@RequestParam Long id, Model model) throws NotFoundException {
	    Pedido pedido = pedidoService.buscarPedidoPorId(id);
	    List<Cliente> cliente = clienteService.getAllClientes();
	    List<Funcionario> funcionario = funcionarioService.getAllFuncionarios();
	    List<Pizza> pizza = pizzaService.listarPizzasComIngredientes();

	    model.addAttribute("pedido", pedido);
	    model.addAttribute("clientes", cliente);
	    model.addAttribute("funcionarios", funcionario);
	    model.addAttribute("pizzas", pizza);

	    return "editarPedido";
	}


	@PostMapping("/atualizar")
	public String atualizarPedido(@ModelAttribute Pedido pedido) {
		pedidoService.atualizarPedido(pedido);
		return "redirect:/pedido/listar";
	}

	@GetMapping("/excluir")
	public String excluirPedido(@RequestParam Long id) {
		pedidoService.removerPedido(id);
		return "redirect:/pedido/listar";
	}

}
