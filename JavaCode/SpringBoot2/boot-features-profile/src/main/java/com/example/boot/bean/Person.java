package com.example.boot.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 小白学java
 * @version 3.0
 */
@Data
@Component
@ConfigurationProperties("person")
public class Person {
    private String name;
    private Integer age;
}
