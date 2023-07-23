package br.edu.iff.bsi.Pizzaria.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.iff.bsi.Pizzaria.entities.*;
import br.edu.iff.bsi.Pizzaria.repository.*;


public class PedidoService {
	@Autowired
	PedidoRepository pedidoRep;

	

	public Pedido salvarPedido(Pedido pedido) {
		return pedidoRep.save(pedido);
	}

	public Pedido atualizarPedido(Pedido pedido) {
		if (pedido.getId() != null) {
			return pedidoRep.save(pedido);
		} else {
			throw new RuntimeException("Pedido inexistente. Favor adicionar a sacola");
		}
	}

	public void removerPedido(Long pedidoId) {
		pedidoRep.deleteById(pedidoId);
	}

	public List<Pedido> listarCompras() throws Exception {
		return pedidoRep.findAll();
	}

	public Pedido buscarPeloID(Long id) {
		return pedidoRep.BuscarPeloId(id);
	}

	public void flush() {
		pedidoRep.flush();
	}

	public void deletarCompra(Pedido pedido) {
		pedidoRep.delete(pedido);
	}

	public Long buscarPeloIDCliente(Long id) {
		return pedidoRep.BuscarPeloIdCliente(id);
	}

}
