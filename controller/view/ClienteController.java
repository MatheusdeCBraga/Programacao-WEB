package br.edu.iff.bsi.Pizzaria.controller.view;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.edu.iff.bsi.Pizzaria.entities.*;
import br.edu.iff.bsi.Pizzaria.repository.*;

@Controller
@RequestMapping(path = "/cliente")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EntregaRepository entregaRepository;

	@GetMapping
	public String page() {
		return "cliente";
	}

	@PostMapping("/addCliente")
	@ResponseBody
	public String addPessoa(Cliente cliente, @RequestParam String rua,@RequestParam int numero, @RequestParam String bairro, @RequestParam String cidade,
			@RequestParam String estado, @RequestParam String cep, @RequestParam String statusEntrega, @RequestParam String formaPagamento ) throws Exception {

		Entrega entrega = new Entrega(null, rua, numero, bairro, cidade, estado, cep, statusEntrega, formaPagamento);

		Entrega enderecoSalvo = entregaRepository.save(entrega);

		

		clienteRepository.save(cliente);

		return "Cliente added --> " + cliente.getId();
	}

	@GetMapping("/getCliente")
	@ResponseBody
	public List<Cliente> getClientes() {
		return clienteRepository.selectAllCliente();
	}

}