package com.example.demo.Web;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;

@Controller

public class MainController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/")
	public String home() {
		return "productPage";
	}
	
	/*
	 * @GetMapping("/login") public String login() { return "login"; }
	 */
	
	/*
	 * @GetMapping("/account#profile") public String account() { return "profile"; }
	 */
	
	@GetMapping("/search")
    public String SearchPage() {
        return "searchPage";
    }

	@GetMapping("/book-details")
    public String ProductInformation() {
        return "productInfo";
    }

	@GetMapping("/account")
    public String ProfileInformation() {
        return "account";
    }

	@GetMapping("/cart")
    public String ShoppingCart() {
        return "shoppingCart";
    }

	@GetMapping("/check-out")
    public String CheckOut() {
        return "checkOut";
    }

	@GetMapping("/admin")
    public String AdminPortal() {
        return "adminBooks";
    }
	
}