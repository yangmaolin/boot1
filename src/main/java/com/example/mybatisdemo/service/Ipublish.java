package com.example.mybatisdemo.service;

import org.springframework.web.multipart.MultipartFile;


public interface Ipublish {
    void publish(MultipartFile file, String title, String word, String id);
}
