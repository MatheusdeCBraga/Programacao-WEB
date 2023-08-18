package br.edu.iff.bsi.Pizzaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import br.edu.iff.bsi.Pizzaria.entities.*;
import br.edu.iff.bsi.Pizzaria.repository.*;

@Service
public class ItemPedidoService {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public List<ItemPedido> listarItemPedidosComPizzas() {
        return itemPedidoRepository.findAll();
    }

    public ItemPedido buscarItemPorId(Long id) throws NotFoundException {
        return itemPedidoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException());
    }
    

    public void salvarItemPedido(ItemPedido itemPedido) {
        itemPedidoRepository.save(itemPedido);
    }

    public void atualizarItem(ItemPedido item) {
        itemPedidoRepository.save(item);
    }

    public void removerItem(Long id) {
        itemPedidoRepository.deleteById(id);
    }
    
    public List<ItemPedido> findAll() {
        return itemPedidoRepository.findAll();
    }

	public ItemPedido realizarAtualizacaoItem(Long id, ItemPedido itemPedidoAtualizado) {
		// TODO Auto-generated method stub
		return null;
	}
}



