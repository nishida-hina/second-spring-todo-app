package com.example.Repository;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.demo.Repository.UserRepository;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void contextLoads() {
        // リポジトリが正しく注入されているかだけのテスト
        assertThat(userRepository).isNotNull();
    }
}