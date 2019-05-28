package com.zzti;


import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

/**
 * jedis的测试类
 */
public class JedisTest {

    @Test
    public void test1(){

        //1.获取连接
        Jedis jedis = new Jedis("localhost",6379);
        //2.操作
        List<String> list =new ArrayList<String>();
        list.add("haha");
        list.add("nihoa");
        jedis.lpush("list");
        //3.关闭连接
        jedis.close();
    }
}
