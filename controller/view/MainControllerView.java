package br.edu.iff.bsi.Pizzaria.controller.view;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.edu.iff.bsi.Pizzaria.entities.Cliente;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping(path = "/home")
public class MainControllerView {

	@GetMapping()
	public String page() {
		return "index";
	}
	
	@PostMapping("/savePessoa")
	public String registerPessoa(@ModelAttribute Cliente cliente) {
		System.out.println("ID da pessoa: " + cliente.getId());
		System.out.println("Nome da pessoa: " + cliente.getNome());
		System.out.println("Endereço da pessoa: " + cliente.getEndereco());
		System.out.println("Telefone da pessoa: " + cliente.getTelefone());
		System.out.println("Senha" +cliente.getPassword());
		return "sucesso";
	}
}