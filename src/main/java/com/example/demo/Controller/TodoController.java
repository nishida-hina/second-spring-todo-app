package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Entity.Todo;
import com.example.demo.Entity.User;
import com.example.demo.Repository.TodoRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.CustomUserDetails;

@Controller
public class TodoController {

	@Autowired
	UserRepository userRepository;
	@Autowired
	TodoRepository todoRepository;

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
		User user = userDetails.getUser();
		List<Todo> todos = todoRepository.findByUser(user);
		model.addAttribute("todos", todos);
		return "todo/main";
	}

	@PostMapping("/todo/add")
	@ResponseBody
	public String add(@RequestParam String title) {
		return title;
	}

}
