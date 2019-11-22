package com.example.mybatisdemo.service.Impl;

import com.example.mybatisdemo.dao.UserDao;
import com.example.mybatisdemo.pojo.User;
import com.example.mybatisdemo.service.ILevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LevelImpl implements ILevel {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> upUserLevel(int id) {
        userDao.upUserLevel(id);
        List<User> ul = userDao.findALlUser();
        List<User> results= new ArrayList<User>();
        for(int i =0;i<=10&&i<=ul.size()-1;i++){
            results.add(ul.get(i));
        }
        return results;
    }

    @Override
    public List<User> delUser(int id) {
        userDao.deleteById(id);
        List<User> ul = userDao.findALlUser();
        List<User> results= new ArrayList<User>();
        for(int i =0;i<=10&&i<=ul.size()-1;i++){
            results.add(ul.get(i));
        }
        return results;
    }

    @Override
    public List<User> downManagerLevel(int id) {
        userDao.downManagerLevel(id);
        List<User> ul = userDao.findAllManager();
        List<User> results= new ArrayList<User>();
        for(int i =0;i<=10&&i<=ul.size()-1;i++){
            results.add(ul.get(i));
        }
        return results;
    }
}
