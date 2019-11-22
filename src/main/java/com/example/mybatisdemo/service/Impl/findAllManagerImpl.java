package com.example.mybatisdemo.service.Impl;

import com.example.mybatisdemo.dao.UserDao;
import com.example.mybatisdemo.pojo.User;
import com.example.mybatisdemo.service.IfindAllManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class findAllManagerImpl implements IfindAllManager {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAllManager(int page) {
        List<User> ul = userDao.findAllManager();
        List<User> results= new ArrayList<User>();
        for(int i =(page*10)-10;i<=page*10&&i<=ul.size()-1;i++){
            results.add(ul.get(i));
        }
        return results;
    }
}
