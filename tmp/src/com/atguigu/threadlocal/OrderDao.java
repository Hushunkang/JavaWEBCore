package com.atguigu.threadlocal;

/**
 * @author hskBeginner Email：2752962035@qq.com
 * @version 1.0
 * @description
 * @create 2020年03月20日 08时02分53秒
 */
public class OrderDao {

    public void saveOrder(){
        String name = Thread.currentThread().getName();
//        System.out.println("OrderDao当前线程【" + name + "】中保存的数据是：" + ThreadLocalTest.data.get(name));
        System.out.println("OrderDao当前线程【" + name + "】中保存的数据是：" + ThreadLocalTest.threadLocal.get());
    }

}
