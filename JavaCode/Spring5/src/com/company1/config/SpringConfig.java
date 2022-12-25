package com.company1.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author 小白学java
 * @version 3.0
 */
//将当前类当做配置类，替代xml配置文件
@Configuration
@ComponentScan(basePackages = "com.company1")
public class SpringConfig {

    //编写测试类
}
