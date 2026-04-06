package com.example.demo.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.Service.CustomUserDetails;

import ch.qos.logback.core.model.Model;

@Controller
public class TodoController {
	
	
	@GetMapping
	public String index() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "index";
	}
	
	
	@GetMapping("/todo/main")
	public String todos(Authentication auth, Model model) {
		CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();
		String email = userDetails.getEmail();
		return email;
		
	}
	
	

}
