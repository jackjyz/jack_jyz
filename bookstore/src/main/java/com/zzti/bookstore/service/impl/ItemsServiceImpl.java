package com.zzti.bookstore.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zzti.bookstore.mapper.BooksMapper;
import com.zzti.bookstore.mapper.ItemsMapper;
import com.zzti.bookstore.mapper.OrdersMapper;
import com.zzti.bookstore.pojo.Books;
import com.zzti.bookstore.pojo.Items;
import com.zzti.bookstore.pojo.ItemsVo;
import com.zzti.bookstore.pojo.Orders;
import com.zzti.bookstore.service.ItemsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class ItemsServiceImpl implements ItemsService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ItemsMapper itemsMapper;
    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private BooksMapper booksMapper;

    public Page<ItemsVo> getAllItemsToPage(String username, int pageNum, int pageSize) {
        Page<ItemsVo> page = PageHelper.startPage(pageNum, pageSize);
        List<ItemsVo> itemsVoList = itemsMapper.selectAllItems(username);
        return page;
    }

    /**
     * 将购物车表中的数据添加到订单表中
     * 并将购物车表清空
     *
     * @param bIds
     * @param username
     * @return
     */
    @Override
    @Transactional
    public Integer setItems(Integer[] bIds, String username) {
        int i=0;
        logger.info(bIds.toString()+"bId集合");
        logger.info("AAAAAAAAAAAAAAAAAAAAaa"+bIds.length);

        for (int bId: bIds) {
            //先获取在购物车表的信息
            Example example = new Example(Orders.class);
            example.createCriteria().andEqualTo("bId",bId).andEqualTo("username",username);
            Orders orders = ordersMapper.selectOneByExample(example);
            logger.info("orders的列表"+orders.toString());

            Books books = booksMapper.selectByPrimaryKey(bId);
            Items items = new Items();
            SimpleDateFormat myFmt2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            items.setCreateData(myFmt2.toString());
            items.setbId(bId);
            items.setUsername(username);
            items.setState(0);
            items.setCount(orders.getNum());
            items.setPrice(books.getbPrice());

            i = itemsMapper.insertSelective(items);
            Example example1 = new Example(Orders.class);
            example1.createCriteria().andEqualTo("bId",bId).andEqualTo("username",username);
            ordersMapper.deleteByExample(example1);
        }
        return i;
    }
}
