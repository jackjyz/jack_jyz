package com.zzti.bookstore.service.impl;

import com.zzti.bookstore.mapper.OrdersMapper;
import com.zzti.bookstore.pojo.OrderVo;
import com.zzti.bookstore.pojo.Orders;
import com.zzti.bookstore.service.OrdersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private OrdersMapper ordersMapper;

    public List<OrderVo> getShopping(String username) {
        return ordersMapper.selectShopppingOrders(username);
    }

    @Override
    public void addToShopping(Integer[] bIds, String username){
        for (Integer bId: bIds) {
            Orders orders=new Orders();
            orders.setbId(bId);
            orders.setUsername(username);
            Example example = new Example(Orders.class);
            example.createCriteria().andEqualTo("bId",bId).andEqualTo("username",username);
            if(ordersMapper.selectOneByExample(example)==null){
                logger.info("加入购物车的图书编号为"+bId);
                orders.setNum(1);
                ordersMapper.insert(orders);
            }else{
                /**
                 * 如果数据库中已经有这条数据就将该orders的num加1
                 * .updateByExampleSelective(orders,example)
                 * 根据条件example，进行数据库更新操作
                 * 将orders1中的数据更新为orders中的数据
                 */
                Orders orders1 = ordersMapper.selectOneByExample(example);
                orders.setNum(orders1.getNum()+1);
                logger.info("orders1.getNum+1:"+(orders1.getNum()+1));
                ordersMapper.updateByExampleSelective(orders,example);
            }
        }
    }
    public Orders selectOneOrdersBybId(Integer bId){
        return ordersMapper.selectByPrimaryKey(bId);
    }

    @Override
    @Transactional
    public void deleteOrders(Integer bid, String username) {
        Example example = new Example(Orders.class);
        example.createCriteria().andEqualTo("bId",bid).andEqualTo("username",username);
        ordersMapper.deleteByExample(example);
    }
}
