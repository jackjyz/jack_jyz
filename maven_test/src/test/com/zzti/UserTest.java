package com.zzti;

import com.zzti.dao.UserDao;
import com.zzti.pojo.User;
import com.zzti.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {
    @Test
    public void findBid(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        //dao测试
        /*UserDao bean = applicationContext.getBean(UserDao.class);
        User user = bean.findUserById(1);
        System.out.println(user.getName());*/
        //service测试
        UserService userService = applicationContext.getBean(UserService.class);
        User userServiceUserById = userService.findUserById(1);
        System.out.println(userServiceUserById.getName());
    }
}
