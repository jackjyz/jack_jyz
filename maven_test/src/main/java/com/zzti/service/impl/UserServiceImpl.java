package com.zzti.service.impl;

import com.zzti.dao.UserDao;
import com.zzti.pojo.User;
import com.zzti.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    public User findUserById(Integer id) {

        return userDao.findUserById(id);
    }
}
