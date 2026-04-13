package com.example.demo.Service;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.Todo;
import com.example.demo.Repository.TodoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class TodoService {
	
	private final TodoRepository todoRepository;
	
	@Transactional
	public Todo save(String title,String description, Integer userId) {
		Todo todo = new Todo();
        todo.setTitle(title);
        todo.setDescription(description);
        todo.setTask_id(userId);
        todo.setStatus(0);
        return todoRepository.save(todo);
	}

}
