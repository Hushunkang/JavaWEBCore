package com.atguigu.test;

import com.atguigu.dao.OrderDao;
import com.atguigu.dao.impl.OrderDaoImpl;
import com.atguigu.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

public class OrderDaoTest {

    @Test
    public void saveOrder() {

        //方法重写/覆盖 体现了 多态 运行时行为 虚拟方法调用 编译时看左边运行时看右边
        OrderDao orderDao = new OrderDaoImpl();

        orderDao.saveOrder(new Order("1234567890",new Date(),new BigDecimal(100),0, 1));

    }
}