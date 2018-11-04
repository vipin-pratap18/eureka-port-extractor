package com.portextractor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/*
 * Port Extracter from Service Regsitry
 * 
 */
@EnableEurekaClient
@SpringBootApplication
public class EurekaPortExtractorApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaPortExtractorApplication.class, args);
    }
}
