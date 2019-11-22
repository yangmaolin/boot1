package com.example.mybatisdemo.controller;


import com.example.mybatisdemo.service.IfindNewsByNid;
import com.example.mybatisdemo.service.Inews;
import com.example.mybatisdemo.service.Ipublish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

@Controller
public class NewsController {

    @Autowired
    private Ipublish ipublish;
    @Autowired
    private Inews inews;
    @Autowired
    private IfindNewsByNid ifindNewsByNid;

    @PostMapping("/publish")
    public String publish(@RequestParam(value = "file") MultipartFile file, @RequestParam(value = "title")String title,
                          @RequestParam(value = "word")String word,@RequestParam(value = "userid")String id){
        System.out.println("111111");
        ipublish.publish(file,title,word,id);
        System.out.println();
        System.out.println("222222");
        return "publish";
    }

    /**
     * 查找所有新闻
     * @param session
     * @return
     */
    @GetMapping("/news")
    public String news(HttpSession session){
        session.setAttribute("newslist",inews.findAllNews());
        System.out.println(inews.findAllNews().size());
        return "news";
    }

    @GetMapping("/findnewsbynid")
    public String findNewsByNid(@RequestParam(value = "nid")String nid,HttpSession session){
        System.out.println("￥￥￥￥￥￥");
        int id = Integer.parseInt(nid);
        session.setAttribute("newd",ifindNewsByNid.findNewsByNid(id));
        System.out.println(ifindNewsByNid.findNewsByNid(id).getImgfile());
        return "new";
    }
}
