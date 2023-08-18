package br.edu.iff.bsi.Pizzaria.controller.view;

import br.edu.iff.bsi.Pizzaria.entities.ItemPedido;
import br.edu.iff.bsi.Pizzaria.entities.Pedido;
import br.edu.iff.bsi.Pizzaria.entities.Pizza;
import br.edu.iff.bsi.Pizzaria.repository.PizzaRepository;
//import br.edu.iff.bsi.Pizzaria.entities.Pedido;
//import br.edu.iff.bsi.Pizzaria.service.PedidoService;
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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		model.addAttribute("saboresPizza", pizzaService.listarSaboresPizza());
		model.addAttribute("clientes", clienteService.listarClientes());
		model.addAttribute("funcionarios", funcionarioService.listarFuncionarios());
		return "pedido";
	}

	@GetMapping("/getSaboresPizza")
	@ResponseBody
	public List<String> getSaboresPizza() {
		List<String> saboresPizza = pizzaService.listarSaboresPizza();
		return saboresPizza;
	}

	private static int numeroPedidoCounter = 1;

	private String gerarNumeroPedidoUnico() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String dataFormatada = dateFormat.format(new Date());

		String numeroPedido = dataFormatada + "-" + numeroPedidoCounter;
		numeroPedidoCounter++;

		return numeroPedido;
	}

	@PostMapping("/savePedido")
	public String savePedido(@ModelAttribute Pedido pedido, HttpServletRequest request) {
		String numeroPedido = gerarNumeroPedidoUnico();
		pedido.setNumeroPedido(numeroPedido);

		List<ItemPedido> itensPedido = new ArrayList<>();

		Enumeration<String> parameterNames = request.getParameterNames();
		while (parameterNames.hasMoreElements()) {
			String paramName = parameterNames.nextElement();
			if (paramName.startsWith("sabor")) {
				String sabor = request.getParameter(paramName);
				String quantidadeParamName = "quantidade" + paramName.substring(5);
				String quantidadeValue = request.getParameter(quantidadeParamName);

				if (quantidadeValue != null && !quantidadeValue.isEmpty()) {
					int quantidade = Integer.parseInt(quantidadeValue);
					Pizza pizza = pizzaRepository.findBySabor(sabor);

					ItemPedido itemPedido = new ItemPedido();
					itemPedido.setQuantidade_de_itens(quantidade);
					itemPedido.setPizza(pizza);
					itemPedido.setPedido(pedido);
					itensPedido.add(itemPedido);
				}
			}
		}

		pedido.setItensPedido(itensPedido);

		pedidoService.salvarPedido(pedido);

		System.out.println("Salvando pedido: " + pedido);

		return "redirect:/pedido/listar";
	}

	@GetMapping("/listar")
	public String listarPedidos(Model model) {
		List<Pedido> pedidos = pedidoService.listarPedidos();
		model.addAttribute("pedidos", pedidos);
		return "listaPedidos";
	}

	@GetMapping("/editar")
	public String editarPedido(@RequestParam Long id, Model model) {
		try {
			Pedido pedido = pedidoService.buscarPedidoPorId(id);
			model.addAttribute("pedido", pedido);
			return "editarPedido";
		} catch (RuntimeException e) {
			throw new RuntimeException("Pedido não encontrado", e);
		}
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

	@GetMapping("/listarTodosAtributos")
	public List<Pedido> listarTodosAtributos() {
		List<Pedido> pedidos = pedidoService.listarPedidos();
		return pedidos;
	}
}
