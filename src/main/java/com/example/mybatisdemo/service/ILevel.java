package com.example.mybatisdemo.service;

import com.example.mybatisdemo.pojo.User;

import java.util.List;

public interface ILevel {
    //根据id升级用户操作
    List<User> upUserLevel(int id);
    //根据id删除用户操作
    List<User> delUser(int id);
    //根据id降级管理员
    List<User> downManagerLevel(int id);
}
