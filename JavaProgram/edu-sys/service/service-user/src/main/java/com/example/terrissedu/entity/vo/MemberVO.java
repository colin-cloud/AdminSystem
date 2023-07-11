package com.example.terrissedu.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Terriss
 * @time 2023-07-06 21:15:08
 * @description 登录用户vo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {

    @ApiModelProperty(value = "手机号")
    private String mobile;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "验证码")
    private String code;
}
