package com.example.boot.auto;

import com.example.boot.bean.HelloProperties;
import com.example.boot.service.HelloService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 小白学java
 * @version 3.0
 */
@Configuration
@ConditionalOnMissingBean(HelloService.class)
@EnableConfigurationProperties(HelloProperties.class) // 默认properties放在容器中，开启绑定
public class HelloServiceAutoConfiguration {

    @Bean
    public HelloService helloService() {
        return new HelloService();
    }
}
