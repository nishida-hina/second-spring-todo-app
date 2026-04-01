package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="second_spring_todo")
public class Todo {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer task_id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

}
