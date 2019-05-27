package com.zzti.bookstore.mapper;

import com.zzti.bookstore.pojo.Items;
import com.zzti.bookstore.pojo.ItemsVo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ItemsMapper extends Mapper<Items> {

    /**
     * 获取所有订单详情
     *
     * @param username
     * @return
     */
    List<ItemsVo> selectAllItems(String username);
}
