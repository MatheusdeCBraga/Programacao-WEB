package br.edu.iff.bsi.Pizzaria.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ch.qos.logback.core.model.Model;


@Controller
public class EntregaController {
	
	@GetMapping("/layoutBase")
    public String minhaPagina(Model model) {
        
        return "layoutBase"; // Retorna o nome do template HTML
    }

}
