package com.zzti.bookstore.pojo;

import lombok.Data;

import javax.persistence.Id;

@Data
public class ItemsVo {
    @Id
    private Integer iId;//订单编号
    private String username;//用户名
    private String createDate;//订单创建时间
    private Integer count;//数量
    private String price;//价格
    private Integer state;//状态，已完成，未完成
    private String totalPrice;//订单总价
    //图书属性
    private Integer bId;//图书编号
    private String bookName;//图书名
    private String bPrice;//图书价格
    private String image;//图书图片
    private Integer stock;//图书库存
}
