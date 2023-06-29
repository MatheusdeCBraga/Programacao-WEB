package br.edu.iff.bsi.Pizzaria.controller.view;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/home")
public class MainControllerView {

	@GetMapping()
	public String page() {
		return "index";
	}
	@GetMapping("/something")
	@ResponseBody
	public String page2() {
		return "index";
	}
	
	@GetMapping("/something2")
	public ResponseEntity<String> page3() {
		String body = "Bla Bla Bla";
		String etag ="oi";
		return ResponseEntity.ok().eTag(etag).body(body);
		
	}

}
