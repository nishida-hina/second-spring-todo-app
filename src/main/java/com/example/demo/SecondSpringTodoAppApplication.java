package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SecondSpringTodoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecondSpringTodoAppApplication.class, args);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String hash = encoder.encode("1234");
        System.out.println(hash);
	}

}
