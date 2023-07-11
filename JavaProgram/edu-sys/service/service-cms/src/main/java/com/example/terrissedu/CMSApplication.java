package com.example.terrissedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Terriss
 * @time 2023-07-05 18:38:16
 * @description TODO
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.example"})
public class CMSApplication {

    public static void main(String[] args) {
        SpringApplication.run(CMSApplication.class, args);
    }
}
