package com.example.mybatisdemo.service.Impl;

import com.example.mybatisdemo.dao.UserDao;
import com.example.mybatisdemo.pojo.User;
import com.example.mybatisdemo.service.IfindUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 接口实现类
 * 实现用户登陆功能，
 */
@Component
public class findUserImpl implements IfindUser {

    @Autowired
    private UserDao userDao;
    /**
     * 查找用户
     * @param user 用户输入的user
     * @return  数据库中对应的user
     */
    @Override
    public User findUser(User user) {
        User u = userDao.findOne(user.getUsername(),user.getPassword());
        return u;
    }
}
