package com.example.mybatisdemo.service;

import com.example.mybatisdemo.pojo.User;

/**
 * 用户登陆接口
 */
public interface IfindUser {
    /**
     * 查找用户
     * @param user 用户输入的user
     * @return  数据库中对应的user
     */
    User findUser(User user);
}
