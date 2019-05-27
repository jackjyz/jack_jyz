package com.zzti.bookstore.controller;

import com.zzti.bookstore.pojo.OrderVo;
import com.zzti.bookstore.service.OrdersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OrdersController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private OrdersService ordersService;


    /**
     * 如果客户端发送/shopping请求，则跳向购物车页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/shopping")
    public String selectShopppingOrders(Model model, HttpSession httpSession) {
        if (null!=httpSession.getAttribute("username")) {
            String username = httpSession.getAttribute("username").toString();
            List<OrderVo> shopping = ordersService.getShopping(username);
            double totalPrice=0;
            for (OrderVo shop : shopping) {
                totalPrice =totalPrice+(Double.parseDouble(shop.getbPrice())*(shop.getNum()));
            }
            logger.info("总价"+totalPrice);
            model.addAttribute("totalPrice",totalPrice);
            model.addAttribute("orderList", shopping);
            return "shopping";
        }else{
            return "login";
        }
    }

    @RequestMapping("/addToShopping")
    public String addToShopping(Integer[] bId, Model model, HttpSession httpSession) {
        if (bId != null) {
            /**
             * 如果不为空则执行插入操作
             */
            String username = httpSession.getAttribute("username").toString();
            ordersService.addToShopping(bId,username);
            model.addAttribute("orderList", ordersService.getShopping(username));
            return "redirect:shopping";
        } else {
            return "redirect:index";
        }
    }

    /**
     * 将指定的购物车数据进行删除
     * @param bId
     * @param httpSession
     * @return
     */
    @RequestMapping("deleteOrders")
    public String deleteOrders(int bId,HttpSession httpSession){
        String username=httpSession.getAttribute("username").toString();
        ordersService.deleteOrders(bId,username);
        return "redirect:shopping";
    }

}
