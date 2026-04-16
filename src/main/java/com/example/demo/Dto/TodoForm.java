package com.example.demo.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.Data;

@Data
public class TodoForm {
	
	@NotBlank(message = "タイトルは1文字以上100文字以下")
	@Size(min = 1, max = 100)
	private String title;
	
	@NotBlank(message = "説明は最大200文字")
	@Size(max = 200)
    private String description;
}
