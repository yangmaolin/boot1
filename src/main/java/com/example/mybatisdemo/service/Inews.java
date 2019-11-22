package com.example.mybatisdemo.service;

import com.example.mybatisdemo.pojo.News;

import java.util.List;

public interface Inews {
    List<News> findAllNews();
}
