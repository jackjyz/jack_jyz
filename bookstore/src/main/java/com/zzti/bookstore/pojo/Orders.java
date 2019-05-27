package com.zzti.bookstore.pojo;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 订单表
 */
@Data
@Table(name = "orders")
public class Orders {
    @Id
    private Integer bId;
    private String username;
    private Integer num;



    public Integer getbId() {
        return bId;
    }

    public void setbId(Integer bId) {
        this.bId = bId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }


}
