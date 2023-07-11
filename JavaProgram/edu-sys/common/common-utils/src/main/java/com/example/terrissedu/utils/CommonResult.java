package com.example.terrissedu.utils;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.omg.CORBA.INTERNAL;

import java.io.Serializable;

/**
 * @author Terriss
 * @time 2023-06-28 09:59:59
 * @description TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> implements Serializable {

    @ApiModelProperty("标志返回结果是否成功")
    private boolean flag;

    @ApiModelProperty("结果状态码")
    private Integer code;

    @ApiModelProperty("信息")
    private String message;

    @ApiModelProperty("数据")
    private T data;

    public void success(String message, T data) {
        this.setFlag(true);
        this.setCode(ResultCode.SUCCESS);
        this.setMessage(message);
        this.setData(data);
    }

    public void error(String message) {
        this.setFlag(false);
        this.setCode(ResultCode.ERROR);
        this.setMessage(message);
    }

    // 设置链式编程
    public CommonResult<T> success() {
        this.setFlag(true);
        this.setCode(ResultCode.SUCCESS);
        return this;
    }

    public CommonResult<T> error() {
        this.setFlag(false);
        return this;
    }

    public CommonResult<T> message(String message) {
        this.setMessage(message);
        return this;
    }

    public CommonResult<T> code(Integer code) {
        this.setCode(code);
        return this;
    }

    public CommonResult<T> data(T data) {
        this.setData(data);
        return this;
    }
}
