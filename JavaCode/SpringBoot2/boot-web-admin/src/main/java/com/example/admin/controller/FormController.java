package com.example.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author 小白学java
 * @version 3.0
 */
@Controller
@Slf4j
public class FormController {

    @GetMapping("/form_layouts")
    public String form() {
        return "form/form_layouts";
    }

    /**
     * MultipartFile 自动封装上传的文件
     * @param email
     * @param username
     * @param headerImg
     * @param photos
     * @return
     */
    @PostMapping("/upload")
    public String upload(@RequestParam(value = "email", required = false) String email,
                         @RequestParam(value = "username", required = false) String username,
                         @RequestPart("headerImg") MultipartFile headerImg,
                         @RequestPart MultipartFile[] photos) throws IOException {
        if (!headerImg.isEmpty()) {
            //保存到文件服务器
            String filename = headerImg.getOriginalFilename();
            headerImg.transferTo(new File("D:\\" + filename));
        }
        if (photos.length > 0) {
            for (MultipartFile multipartFile : photos) {
                if (!multipartFile.isEmpty()) {
                    String filename = multipartFile.getOriginalFilename();
                    multipartFile.transferTo(new File("D:\\photos\\" + filename));
                }
            }
        }
        return "index";
    }
}
