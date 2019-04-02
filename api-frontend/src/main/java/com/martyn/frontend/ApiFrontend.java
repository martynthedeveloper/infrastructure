package com.martyn.frontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiFrontend {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(ApiFrontend.class);
        springApplication.run(args);
    }
}