package br.edu.iff.bsi.Pizzaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iff.bsi.Pizzaria.entities.*;
import br.edu.iff.bsi.Pizzaria.repository.*;

@Service
public class FuncionarioService {

	@Autowired
	FuncionarioRepository funcionarioRep;

	public void addFuncionario(Funcionario funcionario) {
		funcionarioRep.save(funcionario);
	}

	public Funcionario findById(Long id) {
		return funcionarioRep.findById(id).orElse(null);
	}

	public void deleteCliente(Funcionario funcionario) {
		funcionarioRep.delete(funcionario);
	}

	public List<Funcionario> findAll() {
		return funcionarioRep.findAll();
	}

	public Funcionario updateFuncionario(Funcionario funcionario) {
        if (funcionario.getId() != null) {
            return funcionarioRep.save(funcionario);
        } else {
            throw new RuntimeException("Funcionário não cadastrado no Banco de Dados. Favor adiconar.");
        }
    }

    public void deleteFuncionario(Long funcionarioId) {
        funcionarioRep.deleteById(funcionarioId);
    }
}
