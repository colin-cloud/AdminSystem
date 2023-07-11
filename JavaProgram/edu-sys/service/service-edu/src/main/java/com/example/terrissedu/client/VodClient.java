package com.example.terrissedu.client;

import com.example.terrissedu.utils.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Terriss
 * @time 2023-07-05 10:56:45
 * @description TODO
 */
@FeignClient(name = "service-vod", fallback = VodClientImpl.class) //
@Component
public interface VodClient {

    // 定义调用接口的路径
    @DeleteMapping("/edu-vod/vod/removeByVideoId/{videoId}")
    CommonResult<Boolean> removeByVideoId(@PathVariable("videoId") String videoId);
}
