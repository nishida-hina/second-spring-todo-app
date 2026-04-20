package com.example.demo.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.Data;

@Data
public class TodoForm {

    @NotBlank(message = "タイトルは必須です")
    @Size(max = 100, message = "タイトルは100文字以内です")
    private String title;

    @NotBlank(message = "説明は必須です")
    @Size(max = 200, message = "説明は200文字以内です")
    private String description;
}