package com.zzti.bookstore.mapper;

import com.zzti.bookstore.pojo.OrderVo;
import com.zzti.bookstore.pojo.Orders;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface OrdersMapper extends Mapper<Orders> {


    /**
     * 查询用户购物车内的商品
     *
     * @param username
     * @return
     */
    List<OrderVo> selectShopppingOrders(String username);
}
