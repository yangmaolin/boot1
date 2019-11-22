package com.example.mybatisdemo.controller;

import com.example.mybatisdemo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisdemo.pojo.User;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class UserController {

    @Autowired
    private IaddUser iaddUser;
    @Autowired
    private IfindUser ifindUser;
    @Autowired
    private IupdataUser iupdataUser;
    @Autowired
    private IfindAllUser ifindAllUser;
    @Autowired
    private ILevel iLevel;
    @Autowired
    private IfindAllManager ifindAllManager;
    @Autowired
    private IfindUserByUsernameAndPassword ifindUserByUsernameAndPassword;


    /**
     * 首页入口
     * @return 首页
     */
    @GetMapping("/h")
    public String h(){
        return "login";
    }

    /**
     * 注册功能
     * @param user 前台数据
     * @return  登陆页
     */
    @PostMapping("/add")
    public String addUser(@ModelAttribute User user,HttpSession session){
        System.out.println(user.getUsername()+user.getPassword());
        iaddUser.addUser(user);
        User u = ifindUserByUsernameAndPassword.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
        session.setAttribute("info",u);
        return "showinfo";
    }

    /**
     * 登陆功能
     * @param user 前台数据
     * @param session 会话
     * @return 用户首页
     */
    @PostMapping("/login")
    public String login(@ModelAttribute User user, HttpSession session){
        User u =ifindUser.findUser(user);
        if(u!=null){
            session.setAttribute("u",ifindUser.findUser(user));
            session.setAttribute("page",1);
            return "demo";
        }
        return "login";
    }

    /**
     * 点击在右侧显示页面
     * @param session
     * @return 新闻首页页面
     */
    @GetMapping("/tonews")
    public String toa(HttpSession session){
        session.setAttribute("testa","oka");
        return "news";
    }

    /**
     * 点击在右侧显示页面
     * @param session
     * @return 发布新闻页面
     */
    @GetMapping("/topublish")
    public String tob(HttpSession session){
        session.setAttribute("testb","okb");
        return "publish";
    }

    /**
     * 退出登陆功能
     * @param session
     * @return 登陆页
     */
    @GetMapping("/out")
    public String out(HttpSession session){
        //清空会话
        session.invalidate();
        return "login";
    }

    /**
     * @return 个人信息首页
     */
    @GetMapping("/touserinfo")
    public String toUserInfo(){
        return "user";
    }

    /**
     * @return 更新用户页
     */
    @GetMapping("/toupdatauser1")
    public String toUpdataUser(){
        return "updatauser";
    }

    @PostMapping("/updatauser")
    public String updataUser(@ModelAttribute User user,HttpSession session){
        System.out.println(user.getUsername());
        User u = iupdataUser.updataUser(user);
        System.out.println("$$$$$$$$");
        session.setAttribute("u",u);
        return "user";
    }

    /**
     * 点击跳转到alluser页面，且伴随带有用户信息的会话
     * @param session
     * @return alluser页面
     */
    @GetMapping("/toalluser")
    public String toAllUser(@RequestParam("page")int page, HttpSession session){
        List<User> results = ifindAllUser.findAllUser(page);
        if(results.isEmpty()){
            session.setAttribute("page",page-1);
        }else {
            session.setAttribute("page",page);
        }
        session.setAttribute("results",results);
        return "alluser";
    }

    /**
     * 升级user
     * @param id
     * @param session
     * @return
     */
    @GetMapping("/upuserlevel")
    public String upLevel(@RequestParam("id") int id,HttpSession session){
        session.setAttribute("results",iLevel.upUserLevel(id));
        return "alluser";
    }

    /**
     * 删除用户
     * @param id
     * @param session
     * @return
     */
    @GetMapping("/deluser")
    public String delUser(@RequestParam("id") int id,HttpSession session){
        session.setAttribute("results",iLevel.delUser(id));
        return "alluser";
    }

    /**
     * 降职管理员
     * @param id
     * @param session
     * @return
     */
    @GetMapping("/downmanager")
    public String downManager(@RequestParam("id")int id,HttpSession session){
        session.setAttribute("results",iLevel.downManagerLevel(id));
        return "allmanager";
    }

    @GetMapping("/toallmanager")
    public String toAllManager(@RequestParam("page")int page, HttpSession session){
        List<User> results = ifindAllManager.findAllManager(page);
        if(results.isEmpty()){
            session.setAttribute("page",page-1);
        }else {
            session.setAttribute("page",page);
        }
        session.setAttribute("results",results);
        return "allmanager";
    }
}
