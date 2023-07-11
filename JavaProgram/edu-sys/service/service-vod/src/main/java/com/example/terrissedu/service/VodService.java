package com.example.terrissedu.service;


import com.example.terrissedu.utils.CommonResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface VodService {
    CommonResult<Map<String, String>> uploadVideo(MultipartFile file);

    CommonResult<Boolean> removeVideo(String videoId);

    CommonResult<String> getVideoIdById(String id);

}
