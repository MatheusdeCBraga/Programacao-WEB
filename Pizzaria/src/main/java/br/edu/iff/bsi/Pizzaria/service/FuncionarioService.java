package br.edu.iff.bsi.Pizzaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import br.edu.iff.bsi.Pizzaria.entities.*;
import br.edu.iff.bsi.Pizzaria.repository.*;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	public void salvarFuncionario(Funcionario funcionario) {
		funcionarioRepository.save(funcionario);
	}

	public List<Funcionario> listarFuncionarios() {
		return funcionarioRepository.findAll();
	}

	public Funcionario buscarFuncionarioPorId(Long id) throws NotFoundException {
		return funcionarioRepository.findById(id).orElseThrow(() -> new NotFoundException());
	}

	public void atualizarFuncionario(Funcionario funcionario) {
		funcionarioRepository.save(funcionario);
	}

	public void removerFuncionario(Long id) {
		funcionarioRepository.deleteById(id);
	}

	public void addFuncionario(Funcionario funcionario) {
		funcionarioRepository.save(funcionario);
	}

	public Funcionario realizarAtualizacaoFuncionario(Long id, Funcionario funcionarioAtualizado) throws NotFoundException {
	    Funcionario funcionarioExistente = buscarFuncionarioPorId(id);

	    funcionarioExistente.setNome(funcionarioAtualizado.getNome());
	    funcionarioExistente.setSobrenome(funcionarioAtualizado.getSobrenome());
	    funcionarioExistente.setCargo(funcionarioAtualizado.getCargo());
	    funcionarioExistente.setSalario(funcionarioAtualizado.getSalario());
	    funcionarioExistente.setEmail(funcionarioAtualizado.getEmail());
	    funcionarioExistente.setPassword(funcionarioAtualizado.getPassword());

	    return funcionarioRepository.save(funcionarioExistente);
	}

}
