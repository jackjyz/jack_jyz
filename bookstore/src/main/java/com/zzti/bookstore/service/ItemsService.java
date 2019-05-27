package com.zzti.bookstore.service;

import com.github.pagehelper.Page;
import com.zzti.bookstore.pojo.ItemsVo;

public interface ItemsService {

    Page<ItemsVo> getAllItemsToPage(String username, int pageNum, int pageSize);

    Integer setItems(Integer[] bIds,String username);
}
