package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Todo;


@Repository
public interface TodoRepository extends JpaRepository<Todo,Integer>{

}

