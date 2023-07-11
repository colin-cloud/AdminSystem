package com.example.terrissedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Terriss
 * @time 2023-06-30 21:46:35
 * @description OSS主启动类
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) // 取消数据源的自动配置
@ComponentScan({"com.example"})
@EnableDiscoveryClient
public class OSSApplication {

    public static void main(String[] args) {
        SpringApplication.run(OSSApplication.class, args);
    }
}
