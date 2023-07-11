package com.example.terrissedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Terriss
 * @time 2023-07-06 14:15:35
 * @description TODO
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan(basePackages = {"com.example"})
public class SMSApplication {

    public static void main(String[] args) {
        SpringApplication.run(SMSApplication.class, args);
    }
}
