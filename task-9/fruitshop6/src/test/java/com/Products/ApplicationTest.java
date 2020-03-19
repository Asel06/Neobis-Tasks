package com.Products;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootTest
@EnableJpaRepositories
@Configuration
public class ApplicationTest {
    @Test
    public void contextLoads() {
    }
}
