package br.edu.iff.bsi.Pizzaria.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.iff.bsi.Pizzaria.entities.*;
import br.edu.iff.bsi.Pizzaria.repository.*;
public class EntregaService {
	
	@Autowired
	private EntregaRepository entrepo;

	public Entrega addEndereco(Entrega entrega) {
		return entrepo.save(entrega);
	}

	public List<Entrega> getEntrega() {
		return entrepo.selectAllEndereco();
	}


}
