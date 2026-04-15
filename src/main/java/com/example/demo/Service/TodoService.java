package com.example.demo.Service;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.Todo;
import com.example.demo.Entity.User;
import com.example.demo.Repository.TodoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class TodoService {
	
	private final TodoRepository todoRepository;
	
	
	@Transactional
	public Todo save(String title,String description, User user) {
		Todo todo = new Todo();
        todo.setTitle(title);
        todo.setDescription(description);
        todo.setStatus(0);
        todo.setUser(user);
        return todoRepository.save(todo);
	}
	
	@Transactional
	public void updateStatus(Integer id, Integer status) {
		Todo todo = todoRepository.findById(id)
		        .orElseThrow(() -> new RuntimeException("Todo not found with id: " + id));
		
		todo.setStatus(status);
		todoRepository.save(todo);
	}
	
	@Transactional
	public Todo deleteSave(Integer todo_id, User user){
		Todo todo = todoRepository.findByTaskIdAndUser(todo_id, user)
		        .orElseThrow(() -> new RuntimeException("あなたのタスクが見つかりません"));
		todo.setDeleteFlg(1);
		return  todoRepository.save(todo);
	}

}
