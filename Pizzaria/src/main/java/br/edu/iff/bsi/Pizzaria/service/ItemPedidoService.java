package br.edu.iff.bsi.Pizzaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iff.bsi.Pizzaria.entities.*;
import br.edu.iff.bsi.Pizzaria.repository.*;

@Service
public class ItemPedidoService {
	
	@Autowired
	private ItemPedidoRepository item;

	public ItemPedido addItem(ItemPedido itempedido) {
		return item.save(itempedido);
	}

	public List<ItemPedido> getItemPedido() {
		return item.selectAllItemPedido();
	}

}
