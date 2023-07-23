package br.edu.iff.bsi.Pizzaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.iff.bsi.Pizzaria.entities.*;
import br.edu.iff.bsi.Pizzaria.repository.*;
@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;

	public void addCliente(Cliente cliente) {
		clienteRepository.save(cliente);
	}

	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	public List<String> selectAllInfoCliente() {
		return clienteRepository.selectAllInfoCliente();
	}
	
	public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }
	
	public void deleteCliente(Cliente cliente) {
        clienteRepository.delete(cliente);
    }
}
