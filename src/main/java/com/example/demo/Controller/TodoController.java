package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TodoController {
	
	
	@GetMapping(value = "/todo/index")
	public String index() {
		return "/todo/index";
	}

}
