package com.zzti.bookstore.service;

import com.github.pagehelper.Page;
import com.zzti.bookstore.pojo.Books;

public interface BooksService {

    /**
     * 根据搜索关键字进行模糊检索，查询出符合条件的Book
     * 并以分页后的格式返回
     *
     * @param keywords
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<Books> searchBooksByKeywords(String keywords, int pageNum, int pageSize);


    /**
     * 获取分页后的book数据
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<Books> getAllBooksToPage(int pageNum, int pageSize);
}
