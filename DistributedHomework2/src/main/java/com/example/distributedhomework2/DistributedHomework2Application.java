package com.example.distributedhomework2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.distributedhomework2.mapper")
public class DistributedHomework2Application {

    public static void main(String[] args) {
        SpringApplication.run(DistributedHomework2Application.class, args);
    }

}
