package com.example.hr_module;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// TODO: 13.08.2023 Set up DB on start https://docs.spring.io/spring-boot/docs/2.1.x/reference/html/howto-database-initialization.html#howto-database-initialization
@SpringBootApplication
public class HrModuleApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrModuleApplication.class, args);
    }

}
