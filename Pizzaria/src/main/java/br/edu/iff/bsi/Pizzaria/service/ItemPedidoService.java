package br.edu.iff.bsi.Pizzaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iff.bsi.Pizzaria.entities.ItemPedido;
import br.edu.iff.bsi.Pizzaria.repository.ItemPedidoRepository;

import java.util.List;

@Service
public class ItemPedidoService {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public List<ItemPedido> getAllItensPedido() {
        return itemPedidoRepository.findAll();
    }

    public ItemPedido getItemPedidoById(Long id) {
        return itemPedidoRepository.findById(id).orElse(null);
    }

    public ItemPedido createItemPedido(ItemPedido itemPedido) {
        return itemPedidoRepository.save(itemPedido);
    }

    public ItemPedido updateItemPedido(Long id, ItemPedido itemPedido) {
        if (itemPedidoRepository.existsById(id)) {
            itemPedido.setId(id);
            return itemPedidoRepository.save(itemPedido);
        }
        return null;
    }

    public void deleteItemPedido(Long id) {
        itemPedidoRepository.deleteById(id);
    }
}
