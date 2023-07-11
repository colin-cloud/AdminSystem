package com.example.terrissedu.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Terriss
 * @time 2023-07-02 13:12:20
 * @description TODO
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseQuery {

    @ApiModelProperty("根据课程名称进行模糊查询")
    private String title;

    @ApiModelProperty("根据课程执教教师的姓名进行查询")
    private String teacherName;

    @ApiModelProperty("根据课程一级分类名称进行查询")
    private String firstLabel;

    @ApiModelProperty("根据课程二级分类名称进行查询")
    private String secondLabel;

    @ApiModelProperty(value = "查询开始时间", example = "2019-01-01 10:10:10")
    private String begin;

    @ApiModelProperty(value = "查询结束时间", example = "2019-12-01 10:10:10")
    private String end;
}
