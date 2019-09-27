package com.asiainfo.asiainfo_select_sh.controller;

import com.asiainfo.asiainfo_select_sh.service.ShService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
public class ShController {
    @Autowired
    private ShService shServices;

    @RequestMapping(value="sh/{serialNumber}",method = RequestMethod.GET)
    public List<Map<String, Object>> getSh(@PathVariable("serialNumber") String  serialNumber){
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("serialNumber",serialNumber);
        List<Map<String, Object>> sh = shServices.getSh(hashMap);
        return sh;
    }
}
