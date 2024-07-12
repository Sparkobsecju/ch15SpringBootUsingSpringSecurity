package org.example.ch15;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Ch15Application {
    @GetMapping("/")
    public String hello() {
        return "Hello Spring Security! ";
    }

    public static void main(String[] args) {
        SpringApplication.run(Ch15Application.class, args);
    }

}
