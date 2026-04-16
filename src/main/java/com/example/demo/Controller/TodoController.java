package com.example.demo.Controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Dto.ApiResponse;
import com.example.demo.Dto.TodoForm;
import com.example.demo.Entity.Todo;
import com.example.demo.Entity.User;
import com.example.demo.Repository.TodoRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.CustomUserDetails;
import com.example.demo.Service.TodoService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TodoController {
	private final TodoService todoService;

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
		List<Todo> todos = todoRepository.findByUserAndDeleteFlg(user, 0);
		model.addAttribute("todos", todos);
		return "todo/main";
	}

	@PostMapping("/todo/add")
	@ResponseBody
	public ResponseEntity<ApiResponse<?>> add(
			@Valid @ModelAttribute TodoForm todoForm,
			@AuthenticationPrincipal CustomUserDetails currentUser,
			BindingResult bindingResult) {
		User user = currentUser.getUser();
		if (bindingResult.hasErrors()) {
			return  ResponseEntity.badRequest().body(bindingResult.getFieldErrors());;
        }
		return todoService.save(todoForm, user);
	}
	
	@PostMapping("/todo/updateStatus")
	@ResponseBody
	public String updateStatus(@RequestParam Integer id, @RequestParam Integer status) {
	    todoService.updateStatus(id, status);
	    return "ok";
	}
	
	@GetMapping("/todo/delete")
	@ResponseBody
	public Todo delete(@RequestParam int todo_id,@AuthenticationPrincipal CustomUserDetails currentUser) {
		User user = currentUser.getUser();
		return todoService.deleteSave(todo_id, user);
	}

}
