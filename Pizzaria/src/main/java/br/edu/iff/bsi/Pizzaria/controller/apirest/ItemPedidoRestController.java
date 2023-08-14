package br.edu.iff.bsi.Pizzaria.controller.apirest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
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

import br.edu.iff.bsi.Pizzaria.entities.ItemPedido;
import br.edu.iff.bsi.Pizzaria.service.ItemPedidoService;
import br.edu.iff.bsi.Pizzaria.service.PizzaService;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/itempedido")
public class ItemPedidoRestController {

	@Autowired
	private ItemPedidoService itemPedidoService;

	@Autowired
	private PizzaService pizzaService;

	@PostMapping("")
	public ResponseEntity<ItemPedido> addItemPedido(@RequestBody ItemPedido itemPedido) {
		itemPedidoService.salvarItemPedido(itemPedido);
		return ResponseEntity.status(HttpStatus.CREATED).body(itemPedido);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ItemPedido> atualizarItemPedido(
			@PathVariable Long id,
			@RequestBody ItemPedido itemPedidoAtualizado
	) throws NotFoundException {
		ItemPedido itemPedido = itemPedidoService.realizarAtualizacaoItem(id, itemPedidoAtualizado);
		return ResponseEntity.ok(itemPedido);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarItemPedido(@PathVariable Long id) {
		itemPedidoService.removerItem(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("")
	public ResponseEntity<List<ItemPedido>> listarItemPedidos() {
		List<ItemPedido> itemPedidos = itemPedidoService.listarItemPedidosComPizzas();
		return ResponseEntity.ok(itemPedidos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ItemPedido> buscarItemPorId(@PathVariable Long id) {
		try {
			ItemPedido item = itemPedidoService.buscarItemPorId(id);
			return ResponseEntity.ok(item);
		} catch (NotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
}
