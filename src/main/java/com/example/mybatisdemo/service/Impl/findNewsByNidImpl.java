package com.example.mybatisdemo.service.Impl;

import com.example.mybatisdemo.dao.NewsDao;
import com.example.mybatisdemo.pojo.News;
import com.example.mybatisdemo.service.IfindNewsByNid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class findNewsByNidImpl implements IfindNewsByNid {

    @Autowired
    private NewsDao newsDao;

    @Override
    public News findNewsByNid(int nid) {

        return newsDao.findNewsByNid(nid);
    }
}
