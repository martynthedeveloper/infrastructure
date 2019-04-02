package com.martyn.servertests;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiTests {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(ApiTests.class);
        springApplication.run(args);
    }
}