package com.example.aws_ex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class AwsExApplication {

    public static void main(String[] args) {
        SpringApplication.run(AwsExApplication.class, args);
    }

}
