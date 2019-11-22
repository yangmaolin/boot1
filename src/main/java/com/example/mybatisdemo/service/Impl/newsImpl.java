package com.example.mybatisdemo.service.Impl;

import com.example.mybatisdemo.dao.NewsDao;
import com.example.mybatisdemo.pojo.News;
import com.example.mybatisdemo.service.Inews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 查找所有新闻
 */
@Component
public class newsImpl implements Inews {

    @Autowired
    private NewsDao newsDao;

    @Override
    public List<News> findAllNews() {
        List<News> newslist = newsDao.findAll();
        System.out.println("$$$$$"+newslist.size());
        return newslist;
    }
}
