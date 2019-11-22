package com.example.mybatisdemo.service;

import com.example.mybatisdemo.pojo.User;

import java.util.List;

/**
 * 查找所有管理员
 */
public interface IfindAllManager {
    List<User> findAllManager(int page);
}
