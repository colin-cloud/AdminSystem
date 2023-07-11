package com.example.terrissedu.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Terriss
 * @time 2023-06-29 20:24:11
 * @description TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "token值")
    private String token;

    @ApiModelProperty("所属角色")
    private List<String> roles;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "图像")
    private String avatar;

    public UserDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }
}