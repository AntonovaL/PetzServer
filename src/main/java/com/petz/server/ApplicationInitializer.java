package com.petz.server;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
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
}
