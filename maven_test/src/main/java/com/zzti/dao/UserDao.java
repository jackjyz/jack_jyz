package com.zzti.dao;

import com.zzti.pojo.User;

public interface UserDao {
    public User findUserById(Integer id);
}
