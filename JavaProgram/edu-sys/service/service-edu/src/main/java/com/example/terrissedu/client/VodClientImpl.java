package com.example.terrissedu.client;

import com.example.terrissedu.utils.CommonResult;
import com.example.terrissedu.utils.ResultMessage;
import org.springframework.stereotype.Component;

/**
 * @author Terriss
 * @time 2023-07-05 14:40:33
 * @description 熔断机制 -- 当远程调用方法出错时调用该实现类中对应的方法
 */
@Component
public class VodClientImpl implements VodClient {

    @Override
    public CommonResult<Boolean> removeByVideoId(String videoId) {
        return new CommonResult<Boolean>()
                .error()
                .message(ResultMessage.DELETE_VIDEO_ERROR)
                .data(true);
    }
}
