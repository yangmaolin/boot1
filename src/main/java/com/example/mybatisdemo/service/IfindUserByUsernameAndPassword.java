package com.example.mybatisdemo.service;

import com.example.mybatisdemo.pojo.User;

public interface IfindUserByUsernameAndPassword {
    User findUserByUsernameAndPassword(String username,String password);
}
