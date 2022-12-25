package com.example.plus.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * @author 小白学java
 * @version 3.0
 */
@Getter
public enum SexEnum {
    MALE(1, "男"),
    FEMALE(0, "女");

    @EnumValue//将注解所标识的属性的值存储到数据库中
    private Integer sex;
    private String sexName;

    SexEnum(Integer sex, String sexName) {
        this.sex = sex;
        this.sexName = sexName;
    }
}
