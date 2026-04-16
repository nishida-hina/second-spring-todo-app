package com.example.demo.Dto;

public class ApiResponse <T> {
	private boolean status;
    private String message;
    private T data;
	
	 public  ApiResponse (boolean status, String message, T data) { 
	        this .status = status; 
	        this .message = message; 
	        this .data = data; 
	    } 
	 
	 public static <T> ApiResponse<T> success(T data){
		 return new ApiResponse <>(true, "成功です",data);
	 }
	 
	 public static <T> ApiResponse<T> fail(String message,T errorData ){
		 return new ApiResponse<>(false, message, errorData);
	 }
	
}
