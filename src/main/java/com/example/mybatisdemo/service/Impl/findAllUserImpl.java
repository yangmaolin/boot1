package com.example.mybatisdemo.service.Impl;

import com.example.mybatisdemo.dao.UserDao;
import com.example.mybatisdemo.pojo.User;
import com.example.mybatisdemo.service.IfindAllUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 高权限用户查找普通用户
 */
@Component
public class findAllUserImpl implements IfindAllUser {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAllUser(int page) {
        List<User> ul = userDao.findALlUser();
        List<User> results= new ArrayList<User>();
        for(int i =(page*10)-10;i<=page*10&&i<=ul.size()-1;i++){
            results.add(ul.get(i));
        }
        return results;
    }
}
