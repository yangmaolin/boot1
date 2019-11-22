package com.example.mybatisdemo.service.Impl;

import com.example.mybatisdemo.dao.NewsDao;
import com.example.mybatisdemo.pojo.News;
import com.example.mybatisdemo.service.Ipublish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 实现新闻发布
 */
@Component
public class
publishImpl implements Ipublish {

    @Autowired
    private NewsDao newsDao;

    @Override
    public void publish(MultipartFile file, String title, String word, String id) {
        if (file.isEmpty()) {
            System.out.println("文件为空空");
        }
        String fileName = file.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        String filePath = "E://NewIDEAwork//mybatisdemo//src//main//resources//static//img//"; // 上传后的路径
        fileName = UUID.randomUUID() + suffixName; // 新文件名
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String filename = "/static/img/" + fileName;

        News news = new News();
        //news.setId(Integer.parseInt(id));
        //news.setId(1);
        news.setImgfile(fileName);
        news.setWord(word);
        news.setTitle(title);

        newsDao.save(news);
    }
}
