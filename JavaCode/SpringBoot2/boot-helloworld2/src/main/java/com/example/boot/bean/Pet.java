package com.example.boot.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * @author 小白学java
 * @version 3.0
 */
@Data
@ToString
@Component
public class Pet {

    private String name;
    private Double weight;

}
