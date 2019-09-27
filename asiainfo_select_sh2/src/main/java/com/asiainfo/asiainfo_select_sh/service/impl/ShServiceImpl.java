package com.asiainfo.asiainfo_select_sh.service.impl;

import com.asiainfo.asiainfo_select_sh.mapper.tact5.Tact5ShMapper;
import com.asiainfo.asiainfo_select_sh.mapper.uopcrm3.Uopcrm3ShMapper;
import com.asiainfo.asiainfo_select_sh.mapper.uopcrm3.Uopcrm3UserMapper;
import com.asiainfo.asiainfo_select_sh.service.ShService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShServiceImpl implements ShService {

    @Autowired
    private Tact5ShMapper tact5ShMapper;

    @Autowired
    private Uopcrm3ShMapper uopcrm3ShMapper;
    @Override
    public List<Map<String, Object>> getSh(Map<String, Object> map) {
        List<Map<String, Object>> shByMap = tact5ShMapper.findShByMap(map);
        if(shByMap.isEmpty()){
            shByMap=uopcrm3ShMapper.findShByMap(map);
        }
        if(shByMap.isEmpty()){
            HashMap<String, Object> msgMap = new HashMap<>();
            String msg="该用户不存在";
            msgMap.put("msg",msg);
            shByMap.add(msgMap);
        }
        return shByMap;
    }
}
