//package br.edu.iff.bsi.Pizzaria.controller.apirest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import br.edu.iff.bsi.Pizzaria.entities.Pedido;
//import br.edu.iff.bsi.Pizzaria.service.PedidoService;
//import io.swagger.v3.oas.annotations.Operation;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/v1/pedidos")
//public class PedidoRestController {
//
//    @Autowired
//    private PedidoService pedidoService;
//
//    @GetMapping
//    @ResponseBody
//	@Operation(summary = "Listar todos os pedidos")
//    public List<Pedido> getAllPedidos() {
//        return pedidoService.getAllPedidos();
//    }
//
//    @GetMapping("/{id}")
//    @ResponseBody
//	@Operation(summary = "Retornar um pedido em especifico")
//    public Pedido getPedidoById(@PathVariable Long id) {
//        return pedidoService.getPedidoById(id);
//    }
//
//    @PostMapping
//    @ResponseBody
//	@Operation(summary = "Adiconar um pedido em especifíco")
//    
//    public Pedido createPedido(@RequestBody Pedido pedido) {
//        return pedidoService.createPedido(pedido);
//    }
//
//    @PutMapping("/{id}")
//    @ResponseBody
//	@Operation(summary = "Atualizar um pedido em especifíco")
//    public Pedido updatePedido(@PathVariable Long id, @RequestBody Pedido pedido) {
//        return pedidoService.updatePedido(id, pedido);
//    }
//
//    @DeleteMapping("/{id}")
//    @ResponseBody
//	@Operation(summary = "Remover uma pedido em especifíco")
//    public void deletePedido(@PathVariable Long id) {
//        pedidoService.deletePedido(id);
//    }
//}
