package com.spf.euraka_client;

import com.spf.common.exception.AllExceptionHandle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableEurekaClient
@Import(AllExceptionHandle.class)
public class EurakaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurakaClientApplication.class, args);
    }
}
