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

import br.edu.iff.bsi.Pizzaria.entities.Entrega;
import br.edu.iff.bsi.Pizzaria.service.EntregaService;

@RestController
@RequestMapping("/api/v1/entrega")
public class EntregaRestController {

    @Autowired
    private EntregaService entregaService;

    @PostMapping("")
    public ResponseEntity<Entrega> addEntrega(@RequestBody Entrega entrega) {
        entregaService.salvarEntrega(entrega);
        return ResponseEntity.status(HttpStatus.CREATED).body(entrega);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entrega> atualizarEntrega(
            @PathVariable Long id,
            @RequestBody Entrega entregaAtualizada
    ) throws NotFoundException {
        Entrega entrega = entregaService.realizarAtualizacaoEntrega(id, entregaAtualizada);
        return ResponseEntity.ok(entrega);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEntrega(@PathVariable Long id) {
        entregaService.removerEntrega(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("")
    public ResponseEntity<List<Entrega>> listarEntregas() {
        List<Entrega> entregas = entregaService.listarEntregas();
        return ResponseEntity.ok(entregas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entrega> buscarEntregaPorId(@PathVariable Long id) {
        try {
            Entrega entrega = entregaService.buscarEntregaPorId(id);
            return ResponseEntity.ok(entrega);
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

