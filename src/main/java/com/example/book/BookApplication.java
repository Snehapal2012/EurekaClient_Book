package com.example.book;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@Slf4j
@EnableEurekaClient
public class BookApplication {
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {

        SpringApplication.run(BookApplication.class, args);
        System.out.println("......................Welcome to Book Application........................!");
        System.out.println("----------------------------------------------------------------------------");
        log.info("!!!.............Hello Logger...........!!!");
    }

}
