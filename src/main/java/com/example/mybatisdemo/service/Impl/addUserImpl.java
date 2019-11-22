package com.example.mybatisdemo.service.Impl;

import com.example.mybatisdemo.dao.UserDao;
import com.example.mybatisdemo.pojo.User;
import com.example.mybatisdemo.service.IaddUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * IaddUser接口实现类
 * 实现用户注册功能，
 */
@Component
public class addUserImpl implements IaddUser {

    @Autowired
    private UserDao userDao;
    /**
     * 注册方法,userDao调用的是封装好了的方法
     * @param user pojo对象
     * @return 特定页面
     */
    @Override
    public void addUser(User user) {
        user.setLevel(1);
        userDao.save(user);
    }
}
