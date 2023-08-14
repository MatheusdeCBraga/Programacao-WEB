package br.edu.iff.bsi.Pizzaria.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import br.edu.iff.bsi.Pizzaria.entities.*;
import br.edu.iff.bsi.Pizzaria.repository.*;


@Service
public class EntregaService {

    @Autowired
    private EntregaRepository entregaRepository;

    public void salvarEntrega(Entrega entrega) {
        entregaRepository.save(entrega);
    }

    public List<Entrega> listarEntregas() {
        return entregaRepository.findAll();
    }

    public Entrega buscarEntregaPorId(Long id) throws NotFoundException {
        Optional<Entrega> entrega = entregaRepository.findById(id);
        if (entrega.isPresent()) {
            return entrega.get();
        } else {
            throw new NotFoundException();
        }
    }

    public void atualizarEntrega(Entrega entrega) {
        entregaRepository.save(entrega);
    }

    public void removerEntrega(Long id) {
        entregaRepository.deleteById(id);
    }

	public Entrega realizarAtualizacaoEntrega(Long id, Entrega entregaAtualizada) {
		// TODO Auto-generated method stub
		return null;
	}
}

