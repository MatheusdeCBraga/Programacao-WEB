package br.edu.iff.bsi.Pizzaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iff.bsi.Pizzaria.entities.Pedido;
import br.edu.iff.bsi.Pizzaria.entities.Pizza;
import br.edu.iff.bsi.Pizzaria.repository.PedidoRepository;
import br.edu.iff.bsi.Pizzaria.repository.PizzaRepository;

import java.util.List;
import java.util.NoSuchElementException; 

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    
    @Autowired
    private PizzaRepository pizzaRepository;


    public void salvarPedido(Pedido pedido) {
        pedidoRepository.save(pedido);
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido buscarPedidoPorId(Long id) {
        return pedidoRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public void atualizarPedido(Pedido pedido) {
        pedidoRepository.save(pedido);
    }

    public void removerPedido(Long id) {
        pedidoRepository.deleteById(id);
    }
    
    public List<Pizza> listarSaboresPizza() {
        return pizzaRepository.findAll();
    }

	public Pedido realizarAtualizacaoPedido(Long id, Pedido pedidoAtualizado) {
		// TODO Auto-generated method stub
		return null;
	}
}
