package br.edu.iff.bsi.Pizzaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import br.edu.iff.bsi.Pizzaria.entities.Funcionario;
import br.edu.iff.bsi.Pizzaria.repository.FuncionarioRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	public void salvarFuncionario(Funcionario funcionario) {
		funcionarioRepository.save(funcionario);
	}

	public List<Funcionario> getAllFuncionarios() {
		return funcionarioRepository.findAll();
	}

	public Funcionario getFuncionarioById(Long id) throws NotFoundException {
		Optional<Funcionario> optionalFuncionario = funcionarioRepository.findById(id);
		if (!optionalFuncionario.isPresent()) {
			throw new NotFoundException();
		}
		return optionalFuncionario.get();
	}

	public void updateFuncionario(Long id, Funcionario funcionarioDetails) {
		Optional<Funcionario> optionalFuncionario = funcionarioRepository.findById(id);
		if (optionalFuncionario.isPresent()) {
			Funcionario funcionario = optionalFuncionario.get();
			funcionario.setNome(funcionarioDetails.getNome());
			funcionario.setSobrenome(funcionarioDetails.getSobrenome());
			funcionario.setCargo(funcionarioDetails.getCargo());
			funcionario.setEmail(funcionarioDetails.getEmail());
			funcionario.setSalario(funcionarioDetails.getSalario());
			funcionario.setTelefone(funcionarioDetails.getTelefone());
			funcionario.setSenha(funcionarioDetails.getSenha());
			funcionarioRepository.save(funcionario);
		}
	}

	public void deleteFuncionario(Long id) {
		if (funcionarioRepository.findById(id).isPresent()) {
			funcionarioRepository.deleteById(id);
		}
	}
}
