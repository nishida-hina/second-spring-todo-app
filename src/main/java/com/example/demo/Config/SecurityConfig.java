package com.example.demo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration

public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http
	    .authorizeHttpRequests(authz -> authz
	        .requestMatchers("/", "/login", "/css/**", "/js/**").permitAll()
	        .anyRequest().authenticated()
	    )
	    .formLogin(form -> form
	        .loginPage("/login")
	        .defaultSuccessUrl("/todo/main", true)
	        .permitAll()
	    )
	    .logout(logout -> logout
	        .logoutSuccessUrl("/")
	        .permitAll()
	        );
		return http.build();
	}
}
