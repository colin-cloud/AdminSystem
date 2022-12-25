package com.example.plus.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

/**
 * @author 小白学java
 * @version 3.0
 */
@Data
@TableName("product")
public class Product {
    private Long id;
    private String name;
    private Integer price;

    @Version//标识乐观锁版本号
    private Integer version;
}
