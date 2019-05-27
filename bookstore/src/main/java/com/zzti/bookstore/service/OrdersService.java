package com.zzti.bookstore.service;

import com.zzti.bookstore.pojo.OrderVo;
import com.zzti.bookstore.pojo.Orders;

import java.util.List;

public interface OrdersService {

    /**
     * 根据用户名获取该用户购物车内的所有商品信息
     *
     * @param username
     * @return
     */
    List<OrderVo> getShopping(String username);

    /**
     * 将商品添加至购物车
     *
     * @param bIds
     * @param username
     */
    void addToShopping(Integer[] bIds,String username);


    /**
     * 根据bId查询购物车内是否已经有该数据
     *
     * @param bId
     * @return
     */
    Orders selectOneOrdersBybId(Integer bId);

    /**
     * 根据bId和username将购物车内的数据删除
     *
     * @param bid
     * @param username
     */
    void deleteOrders(Integer bid,String username);

}
