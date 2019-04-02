package com.martyn.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiBackend {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(ApiBackend.class);
        springApplication.run(args);
    }
}