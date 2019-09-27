package com.asiainfo.asiainfo_select_sh.controller;

import com.asiainfo.asiainfo_select_sh.service.ShService;
import com.asiainfo.asiainfo_select_sh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@ResponseBody
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/{serialNumber}",method = RequestMethod.GET)
    public List<Map<String, Object>> getUser(@PathVariable("serialNumber") String  serialNumber){
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("serialNumber",serialNumber);
        List<Map<String, Object>> usersByMap = userService.getUser(hashMap);
        System.out.println(usersByMap);
        return usersByMap;
    }

    @RequestMapping("/str")
    public String findString(){
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("serialNumber","18638502779");
        return userService.findString(hashMap);
    }
}
