package br.edu.iff.bsi.Pizzaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import br.edu.iff.bsi.Pizzaria.entities.Cliente;
import br.edu.iff.bsi.Pizzaria.repository.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatus;
import java.util.NoSuchElementException;



import java.util.List;

@Service
public class ClienteService {

	    @Autowired
	    private ClienteRepository clienteRepository;

	    public void salvarCliente(Cliente cliente) {
	        clienteRepository.save(cliente);
	    }

	    public List<Cliente> getAllClientes() {
	        return clienteRepository.findAll();
	    }

	    public Cliente getClienteById(Long id) {
	        return clienteRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Cliente não encontrado"));
	    }



	    public void updateCliente(Long id, Cliente clienteAtualizado) {
	        Cliente cliente = getClienteById(id);
	        cliente.setNome(clienteAtualizado.getNome());
	        cliente.setSobrenome(clienteAtualizado.getSobrenome());
	        cliente.setSenha(clienteAtualizado.getSenha());
	        cliente.setBairro(clienteAtualizado.getBairro());
	        cliente.setEndereco(clienteAtualizado.getEndereco());
	        cliente.setTelefone(clienteAtualizado.getTelefone());
	        clienteRepository.save(cliente);
	    }

	    public void deleteCliente(Long id) {
	        clienteRepository.deleteById(id);
	    }
	}


	

