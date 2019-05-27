package com.zzti.bookstore.service;

import com.zzti.bookstore.pojo.Userinfo;

public interface UserinfoService {

    /**
     * 向用户表中添加一个用户信息
     * 用户注册信息
     *
     * @param userinfo
     */
    void SaveUserinfo(Userinfo userinfo);

    /**
     * 根据用户名查询用户所有信息用于用户登录验证和注册用户名验证
     *
     * @param username
     * @return
     */
    Userinfo getUserinfoByUsername(String username);
}
