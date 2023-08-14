package br.edu.iff.bsi.Pizzaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import br.edu.iff.bsi.Pizzaria.entities.*;
import br.edu.iff.bsi.Pizzaria.repository.*;
@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public void salvarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Cliente buscarClientePorId(Long id) throws NotFoundException {
        return clienteRepository.findById(id).orElseThrow(() -> new NotFoundException());
    }

    public void atualizarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public void removerCliente(Long id) {
        clienteRepository.deleteById(id);
    }

	public boolean clienteExiste(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	public Cliente realizarAtualizacaoCliente(Long id, Cliente clienteAtualizado) throws NotFoundException {
	    Cliente clienteExistente = buscarClientePorId(id);

	    clienteExistente.setNome(clienteAtualizado.getNome());
	    clienteExistente.setSobrenome(clienteAtualizado.getSobrenome());
	    clienteExistente.setEndereco(clienteAtualizado.getEndereco());
	    clienteExistente.setBairro(clienteAtualizado.getBairro());
	    clienteExistente.setTelefone(clienteAtualizado.getTelefone());
	    clienteExistente.setPassword(clienteAtualizado.getPassword());

	    return clienteRepository.save(clienteExistente);
	}


	
}
