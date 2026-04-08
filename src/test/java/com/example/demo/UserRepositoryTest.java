package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void contextLoads() {
        
        User user = User.builder()
                .user_name("Taro")
                .password("pass")
                .email("taro@test.com")
                .build();
        
        User saved = userRepository.save(user);

        Optional<User> result = userRepository.findById(saved.getUser_id());

        assertTrue(result.isPresent());
        assertEquals("Taro", result.get().getUser_name());
    }
}