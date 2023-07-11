package com.example.terrissedu.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Terriss
 * @time 2023-07-10 09:22:09
 * @description TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatisticData {

    @ApiModelProperty("日期区间列表")
    private List<String> dates;

    @ApiModelProperty(value = "数据")
    private List<Integer> data;

}
