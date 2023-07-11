package com.example.terrissedu.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Terriss
 * @time 2023-07-02 09:22:35
 * @description TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subject {

    @ApiModelProperty("课程id")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    @ApiModelProperty(value = "课程标签")
    private String label;

    @ApiModelProperty(value = "子分类数据")
    private List<Subject> children;

    public Subject(Long id, String label) {
        this.id = id;
        this.label = label;
    }
}
