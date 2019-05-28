package com.zzti.controller;

import com.zzti.pojo.User;
import com.zzti.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/1")
    public String findUsers(Model model){
        User userById = userService.findUserById(1);
        model.addAttribute("item",userById);

        return "index";

    }


}
