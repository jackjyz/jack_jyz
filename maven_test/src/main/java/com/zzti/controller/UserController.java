package com.zzti.controller;

import com.zzti.pojo.User;
import com.zzti.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public String findUsers(Model model,@PathVariable("userId") Integer userId){
        User userById = userService.findUserById(userId);
        model.addAttribute("item",userById);

        return "index";

    }


}
