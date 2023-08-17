package br.edu.iff.bsi.Pizzaria.controller.apirest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.edu.iff.bsi.Pizzaria.entities.ItemPedido;
import br.edu.iff.bsi.Pizzaria.repository.ItemPedidoRepository;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@RestController
@RequestMapping("/api/v1/itens-pedido")
public class ItemPedidoRestController {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @GetMapping
    @ResponseBody
	@Operation(summary = "Listar todos os produtos do pedido")
    public List<ItemPedido> getAllItensPedido() {
        return itemPedidoRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
	@Operation(summary = "Retornar item pedido especifico especifíco")
    public ItemPedido getItemPedidoById(@PathVariable Long id) {
        return itemPedidoRepository.findById(id).orElse(null);
    }

    @PostMapping
    @ResponseBody
	@Operation(summary = "Criar um item no pedido")
    public ItemPedido createItemPedido(@RequestBody ItemPedido itemPedido) {
        return itemPedidoRepository.save(itemPedido);
    }

    @PutMapping("/{id}")
    @ResponseBody
	@Operation(summary = "Atualizar um itemPedido em especifíco")
    public ItemPedido updateItemPedido(@PathVariable Long id, @RequestBody ItemPedido itemPedido) {
        if (itemPedidoRepository.existsById(id)) {
            itemPedido.setId(id);
            return itemPedidoRepository.save(itemPedido);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    @ResponseBody
	@Operation(summary = "Remover o itempedido")
    public void deleteItemPedido(@PathVariable Long id) {
        itemPedidoRepository.deleteById(id);
    }
}
