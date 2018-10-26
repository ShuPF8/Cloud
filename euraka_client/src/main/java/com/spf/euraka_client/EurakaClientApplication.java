package com.spf.euraka_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurakaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurakaClientApplication.class, args);
    }
}
