package com.zzti.bookstore.controller;

import com.github.pagehelper.Page;
import com.zzti.bookstore.pojo.ItemsVo;
import com.zzti.bookstore.service.ItemsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class ItemsController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ItemsService itemsService;

    /**
     * 跳转至历史订单列表
     *
     * @param model
     * @return
     */
    @RequestMapping("/itemslist")
    public String orderList(Model model, Integer pageNum, HttpSession httpSession) {
        if (pageNum == null) {
            pageNum = 1;
        }
        String username = httpSession.getAttribute("username").toString();
        //设定每页的大小为5
        Page<ItemsVo> itemsVoList = itemsService.getAllItemsToPage(username, pageNum, 5);
        model.addAttribute("itemsVoList", itemsVoList);
        logger.info("订单分页：" + itemsVoList.toString());
        return "itemslist";
    }

    /**
     * 将购物车内的Book添加到订单
     * @param model
     * @param bIds
     * @param httpSession
     * @return
     */
    @RequestMapping("shopping-success")
    public String setItems(Model model,Integer[] bIds,HttpSession httpSession){
        Integer setNum = itemsService.setItems(bIds, httpSession.getAttribute("username").toString());
        model.addAttribute("setNum",setNum);
        return "shopping-success";
    }

}
