package br.edu.iff.bsi.Pizzaria.controller.apirest;

import java.util.List;

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

import br.edu.iff.bsi.Pizzaria.entities.Cliente;
import br.edu.iff.bsi.Pizzaria.service.ClienteService;

@RestController
@RequestMapping(path = "/api/v1/cliente")
public class ClienteRestController {

    @Autowired
    public ClienteService clienteServ;

    @PostMapping("")
    public ResponseEntity<Cliente> addCliente(@RequestBody Cliente cliente) {
        clienteServ.salvarCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarCliente(
            @PathVariable Long id,
            @RequestBody Cliente clienteAtualizado
    ) throws NotFoundException {
        Cliente cliente = clienteServ.realizarAtualizacaoCliente(id, clienteAtualizado);
		return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        clienteServ.removerCliente(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("")
    public ResponseEntity<List<Cliente>> listarClientes() {
        List<Cliente> clientes = clienteServ.listarClientes();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarClienteId(@PathVariable Long id) {
        try {
            Cliente cliente = clienteServ.buscarClientePorId(id);
            return ResponseEntity.ok(cliente);
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}


