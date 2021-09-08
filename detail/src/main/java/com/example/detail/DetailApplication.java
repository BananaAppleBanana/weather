package com.example.detail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DetailApplication {

    public static void main(String[] args) {
        SpringApplication.run(DetailApplication.class, args);
    }

}
