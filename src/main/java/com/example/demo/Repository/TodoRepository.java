package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Todo;
import com.example.demo.Entity.User;


@Repository
public interface TodoRepository extends JpaRepository<Todo,Integer>{
	List<Todo> findByUser(User user);
	Optional<Todo> findByTaskIdAndUser(Integer taskId, User user);
}




