package com.example.mybatisdemo.service;

import com.example.mybatisdemo.pojo.User;

import java.util.List;

public interface IfindAllUser {
    List<User> findAllUser(int page);
}
