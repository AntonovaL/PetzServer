package com.petz.server;


import com.petz.server.service.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@ComponentScan
@EnableAutoConfiguration
public class ApplicationInitializer {

    public static void main(String[] args) {
        String encoded=new BCryptPasswordEncoder().encode("123");
        System.out.println(encoded);
        SpringApplication.run(ApplicationInitializer.class, args);
    }

    /*@Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            storageService.init();
        };
    }*/
}
