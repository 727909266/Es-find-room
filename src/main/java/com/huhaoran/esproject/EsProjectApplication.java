package com.huhaoran.esproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude= SecurityAutoConfiguration.class)
@RestController
public class EsProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsProjectApplication.class, args);
    }

    @GetMapping("/hello/world")
    public String helloWorld() {
        return "Hello world!";
    }



}

