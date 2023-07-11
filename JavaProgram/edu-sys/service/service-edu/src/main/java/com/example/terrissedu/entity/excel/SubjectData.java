package com.example.terrissedu.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Terriss
 * @time 2023-07-01 14:48:02
 * @description 读取Excel的对象
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectData {

    @ExcelProperty(index = 0)
    private String firstTitle;

    @ExcelProperty(index = 1)
    private String secondTitle;
}
