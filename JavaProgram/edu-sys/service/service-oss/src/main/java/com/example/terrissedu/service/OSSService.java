package com.example.terrissedu.service;


import org.springframework.web.multipart.MultipartFile;

public interface OSSService {
    String upload(MultipartFile file) throws Exception;
}
