package com.example.terrissedu.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Terriss
 * @time 2023-07-10 09:18:52
 * @description TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatisticQuery {

    @ApiModelProperty("查询type类型数据")
    private String type;

    @ApiModelProperty(value = "查询开始时间", example = "2019-01-01")
    private String begin;

    @ApiModelProperty(value = "查询结束时间", example = "2019-12-01")
    private String end;
}
