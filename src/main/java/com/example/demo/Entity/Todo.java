package com.example.demo.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder 
@Entity
@Table(name="second_spring_todo")
public class Todo {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "task_id",nullable = false) 
    private Integer task_id;
	
	@ManyToOne
	@JoinColumn(name = "user_id",nullable = false)
	private User user;
	
	@Column(name = "title" ,length = 50 ,nullable = false)
	private String title;
	
	@Column(name = "description" ,length = 2000 ,nullable = true)
	private String description;
	
	@Column(name = "status" ,nullable = false)
	@Builder.Default
    private Integer status = 0; 
	
	@Column(name = "deleteFlg" ,nullable = false)
	@Builder.Default
    private Integer deleteFlg = 0; 
	
	@Column(name = "created_at" ,updatable = false)
	private LocalDateTime created_at;
	
	@Column(name = "updated_at" ,updatable = false)
	private LocalDateTime updated_at;
}
