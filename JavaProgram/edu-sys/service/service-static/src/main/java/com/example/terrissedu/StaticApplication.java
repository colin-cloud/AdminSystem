package com.example.terrissedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Terriss
 * @time 2023-07-09 21:46:19
 * @description TODO
 */
@EnableScheduling // 开启定时任务
@SpringBootApplication
@ComponentScan(basePackages = {"com.example"})
@EnableDiscoveryClient
@EnableFeignClients
public class StaticApplication {

    public static void main(String[] args) {
        SpringApplication.run(StaticApplication.class, args);
    }

}
