package br.edu.iff.bsi.Pizzaria.controller.apirest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.edu.iff.bsi.Pizzaria.entities.Cliente;
import br.edu.iff.bsi.Pizzaria.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteRestController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("")
	@ResponseBody
	@Operation(summary = "Listar todos os clientes")
    public List<Cliente> getAllClientes() {
        return clienteService.getAllClientes();
    }

    @GetMapping("/{id}")
	@ResponseBody
	@Operation(summary = "Retornar um cliente em especifíco")
    public Cliente getClienteById(@PathVariable Long id) {
        return clienteService.getClienteById(id);
    }

    @PostMapping
    @ResponseBody
    @Operation(summary = "Adicionar um cliente em especifíco")
    public Cliente createCliente(@RequestBody Cliente cliente) {
        return clienteService.createCliente(cliente);
    }

    @PutMapping("/{id}")
	@ResponseBody
	@Operation(summary = "Atualizar um cliente em especifíco")
    public Cliente updateCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteService.updateCliente(id, cliente);
    }

    @DeleteMapping("/{id}")
	@ResponseBody
	@Operation(summary = "Deletar um cliente em especifíco")
    public void deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
    }
}
