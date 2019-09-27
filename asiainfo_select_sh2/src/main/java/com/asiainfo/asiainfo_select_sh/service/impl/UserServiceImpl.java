package com.asiainfo.asiainfo_select_sh.service.impl;

import com.asiainfo.asiainfo_select_sh.mapper.tact5.Tact5UserMapper;
import com.asiainfo.asiainfo_select_sh.mapper.uopcrm2.Uopcrm2UserMapper;
import com.asiainfo.asiainfo_select_sh.mapper.uopcrm3.Uopcrm3UserMapper;
import com.asiainfo.asiainfo_select_sh.mapper.uopcrm4.Uopcrm4UserMapper;
import com.asiainfo.asiainfo_select_sh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private Tact5UserMapper tact5userMapper;

    @Autowired
    private Uopcrm3UserMapper uopcrm3UserMapper;

    @Autowired
    private Uopcrm4UserMapper uopcrm4UserMapper;
    @Override
    public List<Map<String, Object>> getUser(Map<String,Object> map) {
        List<Map<String, Object>> usersByMap = tact5userMapper.findUserByMap(map);
        System.out.println(usersByMap.isEmpty());
        if(usersByMap.isEmpty()){
            usersByMap = uopcrm3UserMapper.findUserByMap(map);
        }
        if(usersByMap.isEmpty()){
            Map<String,Object> msgMap=new HashMap<>();
            msgMap.put("msg","该用户不存在");
            usersByMap.add(msgMap);
        }
        System.out.println(usersByMap);
        return usersByMap;
    }

    @Override
    public String findString(Map<String, Object> map) {
        return "ioarhgoaehighaodi";
    }
}
