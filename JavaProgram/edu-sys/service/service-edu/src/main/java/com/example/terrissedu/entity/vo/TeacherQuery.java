package com.example.terrissedu.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Terriss
 * @time 2023-06-28 11:05:23
 * @description TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherQuery {

    @ApiModelProperty("根据教师名称进行模糊查询")
    private String name;

    @ApiModelProperty("根据教师的头衔进行查询")
    private Integer level;

    @ApiModelProperty(value = "查询开始时间", example = "2019-01-01 10:10:10")
    private String begin;

    @ApiModelProperty(value = "查询结束时间", example = "2019-12-01 10:10:10")
    private String end;
}
