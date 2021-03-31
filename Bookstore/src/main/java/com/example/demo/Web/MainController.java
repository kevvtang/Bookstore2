package com.example.demo.Web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String home() {
		return "productPage";
	}
	
	 @GetMapping("/login") public String login() { return "login"; } 
}