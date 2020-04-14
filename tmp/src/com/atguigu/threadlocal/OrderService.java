package com.atguigu.threadlocal;

/**
 * @author hskBeginner Email：2752962035@qq.com
 * @version 1.0
 * @description
 * @create 2020年03月20日
 */
public class OrderService {

    public void createOrder(){
        String name = Thread.currentThread().getName();
//        System.out.println("OrderService当前线程【" + name + "】中保存的数据是：" + ThreadLocalTest.data.get(name));
        System.out.println("OrderService当前线程【" + name + "】中保存的数据是：" + ThreadLocalTest.threadLocal.get());
        new OrderDao().saveOrder();
    }

}
