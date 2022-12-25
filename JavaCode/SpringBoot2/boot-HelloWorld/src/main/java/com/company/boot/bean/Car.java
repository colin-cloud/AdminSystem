package com.company.boot.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 小白学java
 * @version 3.0
 */

/**
 * 只有在容器中的组件，才会有SpringBoot的功能
 */
//@Component
//和配置文件中的信息进行绑定
@Data
@Component
@ToString
@ConfigurationProperties(prefix = "mycar")
public class Car {

    private String brand;
    private Integer price;

}
