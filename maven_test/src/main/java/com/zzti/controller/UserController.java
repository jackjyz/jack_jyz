package com.zzti.controller;

import com.zzti.enumpage.color;
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

    //该表中目前id只有1,2,3,4.
    @GetMapping("/{userId}")
    public String findUsers(Model model,@PathVariable("userId") Integer userId){
        User userById = userService.findUserById(userId);
        model.addAttribute("item",userById);
        Integer a = 123;
        System.out.println("反射机制测试："+a.getClass());
        try {
            Class<?> aClass = Class.forName("com.zzti.pojo.User");
            System.out.println("Class.forName(\"a\"):"+aClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(color.GREEN.getName());
        return "index";
    }
}
