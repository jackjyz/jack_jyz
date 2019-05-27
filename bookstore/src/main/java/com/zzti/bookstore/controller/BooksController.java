package com.zzti.bookstore.controller;

import com.github.pagehelper.Page;
import com.zzti.bookstore.pojo.Books;
import com.zzti.bookstore.service.BooksService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class BooksController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private BooksService booksService;

    /**
     * 搜索
     * 搜索结果以分也形式返回
     *
     * @param model
     * @param keywords
     * @return
     */
    @RequestMapping("/search")
    public String search(Model model, String keywords,Integer pageNum) {
        //logger.info(keywords);
        if(pageNum==null||pageNum==0){
            pageNum=1;
        }
        logger.info("当前页号" + pageNum);
        /**
         * pageNum:当前页
         * pageSize:每页列数
         */
        Page<Books> booksByKeywords = booksService.searchBooksByKeywords(keywords, pageNum, 5);
        model.addAttribute("bookslist", booksByKeywords);
        return "index";
    }

    @RequestMapping("/buyBooks")
    public String buyBooks(Integer bIds,Model model){


        return "";
    }


}
