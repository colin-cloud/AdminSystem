package com.colin.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 小白学java
 * @version 3.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
//指定表的名字 --- mybatis-plus
@TableName("tb_user")
public class User {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String username;
    //忽略字段不展示给前端
//    @JsonIgnore
    private String password;
    private Character sex;
    private String address;
    private String createTime;
}
