package com.zzti.bookstore.service.impl;

import com.zzti.bookstore.mapper.UserinfoMapper;
import com.zzti.bookstore.pojo.Userinfo;
import com.zzti.bookstore.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserinfoServiceImpl implements UserinfoService {

    @Autowired
    private UserinfoMapper userinfoMapper;


    @Override
    public void SaveUserinfo(Userinfo userinfo) {
        userinfoMapper.insert(userinfo);
    }

    @Override
    public Userinfo getUserinfoByUsername(String username) {

        return userinfoMapper.selectByPrimaryKey(username);
    }


}
