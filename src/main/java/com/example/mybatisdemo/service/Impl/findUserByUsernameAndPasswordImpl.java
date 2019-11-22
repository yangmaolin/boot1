package com.example.mybatisdemo.service.Impl;

import com.example.mybatisdemo.dao.UserDao;
import com.example.mybatisdemo.pojo.User;
import com.example.mybatisdemo.service.IfindUserByUsernameAndPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class findUserByUsernameAndPasswordImpl implements IfindUserByUsernameAndPassword {

    @Autowired
    private UserDao userDao;

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        return userDao.findUserByUsernameAndPassword(username,password);
    }
}
