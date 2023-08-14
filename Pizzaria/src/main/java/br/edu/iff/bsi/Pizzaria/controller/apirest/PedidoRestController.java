package br.edu.iff.bsi.Pizzaria.controller.apirest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iff.bsi.Pizzaria.entities.Pedido;
import br.edu.iff.bsi.Pizzaria.repository.PizzaRepository;
import br.edu.iff.bsi.Pizzaria.service.ClienteService;
import br.edu.iff.bsi.Pizzaria.service.FuncionarioService;
import br.edu.iff.bsi.Pizzaria.service.PedidoService;
import br.edu.iff.bsi.Pizzaria.service.PizzaService;

@RestController
@RequestMapping("/api/v1/pedido")
public class PedidoRestController {

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

	@PostMapping("")
	public ResponseEntity<Pedido> addPedido(@RequestBody Pedido pedido) {
		pedidoService.salvarPedido(pedido);
		return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Pedido> atualizarPedido(
			@PathVariable Long id,
			@RequestBody Pedido pedidoAtualizado
	) {
		Pedido pedido = pedidoService.realizarAtualizacaoPedido(id, pedidoAtualizado);
		return ResponseEntity.ok(pedido);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarPedido(@PathVariable Long id) {
		pedidoService.removerPedido(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("")
	public ResponseEntity<List<Pedido>> listarPedidos() {
		List<Pedido> pedidos = pedidoService.listarPedidos();
		return ResponseEntity.ok(pedidos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pedido> buscarPedidoPorId(@PathVariable Long id) {
		try {
			Pedido pedido = pedidoService.buscarPedidoPorId(id);
			return ResponseEntity.ok(pedido);
		} catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
}
