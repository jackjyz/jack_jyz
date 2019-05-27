package com.zzti.bookstore.controller;

import com.github.pagehelper.Page;
import com.zzti.bookstore.pojo.Books;
import com.zzti.bookstore.pojo.Userinfo;
import com.zzti.bookstore.service.BooksService;
import com.zzti.bookstore.service.UserinfoService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


@Controller
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private BooksService booksService;

    @Autowired
    private UserinfoService userinfoService;

    @RequestMapping("/index")
    public String hello(Model model, @Param("pageNum") Integer pageNum) {
        if(pageNum==null){
            pageNum=1;
        }
        logger.info("当前页号" + pageNum);
        /**
         * pageNum:当前页
         * pageSize:每页列数
         */
        Page<Books> page = booksService.getAllBooksToPage(pageNum, 5);
        logger.info(page.toString());
        model.addAttribute("bookslist", page);
        logger.info("show page=====" + page.get(0).toString());
        return "index";
    }

    @RequestMapping("/login")
    public String login(String username, String password, HttpSession httpSession, Model model) {
        if (null!=username && null!=password ) {
            Userinfo userinfo = userinfoService.getUserinfoByUsername(username);

            if (userinfo!=null && username.equals(userinfo.getUsername()) && password.equals(userinfo.getPassword())) {
                httpSession.setAttribute("username", username);
                logger.info(httpSession.getAttribute("username") + "1234");
                httpSession.getAttribute("username" + "12312");
                return "redirect:index";
            } else {
                model.addAttribute("msg", "账号或密码错误");
                return "login";
            }
        } else {
            model.addAttribute("msg", "请填入账号和密码");
            return "login";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.invalidate();
        return "/login";
    }

    /**
     * 对用户进行注册
     * 如果执行成功就跳转向注册成功页面
     *
     * @param
     * @return
     */
    @RequestMapping("/register")
    public String Register() {
            return "register";
    }

    @RequestMapping("toRegister")
    public String ToRegister(Userinfo userinfo,Model model) {
        String msg=null;
        if (userinfo.getUsername().equals("")){
            msg="请输入用户名";
            model.addAttribute("msg",msg);
            return "register";
        }else if (userinfo.getPassword().equals("")){
            msg="请输入密码";
            model.addAttribute("msg",msg);
            return "register";
        }else if (userinfo.getEmail().equals("")){
            msg="请输入Email";
            model.addAttribute("msg",msg);
            return "register";
        }else{
            Userinfo userinfoByUsername = new Userinfo();
            userinfoByUsername = userinfoService.getUserinfoByUsername(userinfo.getUsername());
            if (null==userinfoByUsername) {
                userinfoService.SaveUserinfo(userinfo);
                return "register_success";
            } else {
                msg="该用户名已被注册";
                model.addAttribute("msg",msg );
                return "register";
            }
        }
    }
}
