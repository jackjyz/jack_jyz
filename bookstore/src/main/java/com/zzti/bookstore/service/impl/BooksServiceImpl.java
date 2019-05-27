package com.zzti.bookstore.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zzti.bookstore.mapper.BooksMapper;
import com.zzti.bookstore.pojo.Books;
import com.zzti.bookstore.service.BooksService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

@Service
public class BooksServiceImpl implements BooksService {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private BooksMapper booksMapper;

    /**
     * 获取总页数并返回
     *
     * @return Page<Books>
     */
    @Override
    public Page<Books> getAllBooksToPage(int pageNum, int pageSize) {
        // 分页插件: 查询第1页，每页10行
        Page<Books> page = PageHelper.startPage(pageNum, pageSize);
        booksMapper.selectAll();
        /**
         * 以下是对page方法的测试
         */
        // 数据表的总行数
        //logger.info("数据表总行数:"+""+page.getTotal());
        // 分页查询结果的总行数
        //logger.info("分页查询结果的总行数:"+""+page.size());
        // 第一个User对象，参考list，序号0是第一个元素，依此类推
        //logger.info(" 第一个User对象:"+""+page.get(0));
        return page;
    }

    @Override
    public Page<Books> searchBooksByKeywords(String keywords, int pageNum, int pageSize) {

        Example example = new Example(Books.class);
        String keyword = "%" + keywords + "%";
        example.createCriteria().orLike("bookName", keyword);
        Page<Books> page = PageHelper.startPage(pageNum, pageSize);
        booksMapper.selectByExample(example);
        return page;
    }

}
