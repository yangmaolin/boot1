package com.example.mybatisdemo.service.Impl;

import com.example.mybatisdemo.dao.UserDao;
import com.example.mybatisdemo.pojo.User;
import com.example.mybatisdemo.service.IupdataUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * 更新用户功能
 */
@Component
public class updataUserImpl implements IupdataUser {

    @Autowired
    private UserDao userDao;

    @Override
    public User updataUser(User user) {
        Integer id = user.getId();
        String username = user.getUsername();
        String password = user.getPassword();
        String phone = user.getPhone();
        //数据库跟新用户信息
        userDao.updataUser(id,username,password,phone);
        //调用根据用户id查找用户方法并放进session以便user.html显示
        User u = userDao.findUserById(user.getId());
        return u;
    }
}
