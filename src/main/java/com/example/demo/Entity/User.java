package com.example.demo.Entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name="user")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer user_id;
	
	@Column(name = "user_name" ,length = 50 ,nullable = false)
	private String username;
	
	@Column(name = "password" ,length = 100 ,nullable = false)
	private String password;
	
	@Column(name = "email" ,length = 50 ,nullable = false)
	private String email;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Todo> todos;

}
