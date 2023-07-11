package com.example.terrissedu.controller;

import com.example.terrissedu.service.OSSService;
import com.example.terrissedu.utils.CommonResult;
import com.example.terrissedu.utils.ResultMessage;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Terriss
 * @time 2023-06-30 21:53:26
 * @description 上传文件的后端接口
 */
@RestController
@RequestMapping("/edu-oss/ossFile")
@CrossOrigin
@Api(tags = "文件管理")
public class OSSController {

    @Autowired
    private OSSService ossService;

    // 上传头像
    @PostMapping("/upload")
    public CommonResult<String> upload(MultipartFile file) {
        String url = null;
        try {
            url = ossService.upload(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        CommonResult<String> res = new CommonResult<>();
        return res.success().message(ResultMessage.UPLOAD_AVATAR_SUCCESS).data(url);
    }
}
