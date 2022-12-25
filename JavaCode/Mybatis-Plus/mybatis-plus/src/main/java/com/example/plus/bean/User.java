package com.example.plus.bean;

import com.baomidou.mybatisplus.annotation.*;
import com.example.plus.enums.SexEnum;
import lombok.*;

/**
 * @author 小白学java
 * @version 3.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
//@Getter
//@Setter
//@EqualsAndHashCode
//@TableName("user")
public class User {

    //将属性对应的字段指定为主键
    //value属性用于指定主键的字段
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(value = "name")
    private String name;

    private Integer age;

    private String email;

    @TableLogic
    private Integer isDeleted;

    private SexEnum sex;

    public User(Long id, String name, Integer age, String email, Integer isDeleted) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.isDeleted = isDeleted;
    }
}
