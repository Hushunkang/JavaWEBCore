package com.atguigu.threadlocal;

import java.util.Random;

/**
 * @author hskBeginner Email：2752962035@qq.com
 * @version 1.0
 * @description
 * @create 2020年03月20日
 */
public class ThreadLocalTest {

//    public static Map<String,Object> data = new Hashtable<>();
    //ConcurrentHashMap使用了分段锁技术，是线程安全的，在高并发的情形下使用
//    public static Map<String,Object> data = new ConcurrentHashMap<>();
    public static ThreadLocal<Object> threadLocal = new ThreadLocal<>();
    public static ThreadLocal<Object> threadLocal2 = new ThreadLocal<>();
    private static Random random = new Random();

    public static class Task implements Runnable{

        @Override
        public void run() {

//            threadLocal.set("abc");
//            threadLocal2.set("def");
//            System.out.println(threadLocal.get());//abc
//            System.out.println(threadLocal2.get());//def

            //在run方法中随机生成一个变量（线程要关联的数据），然后以当前线程名为key保存到map中
            Integer i = random.nextInt(1000);
            //获取当前线程名
            String name = Thread.currentThread().getName();
            System.out.println("当前线程名称为：【" + name + "】，生成的随机数是：" + i);
//            data.put(name,i);
            threadLocal.set(i);

            try {
                Thread.currentThread().sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new OrderService().createOrder();

            //在run方法结束之前，以当前线程名取出数据并打印。查看是否可以取出操作。。。
//            Object o = data.get(name);
            Object o = threadLocal.get();
            System.out.println("在线程【" + name + "】快结束时取出关联的数据是：" + o);
        }

    }

    public static void main(String[] args) {
//        System.out.println("当前线程名称为：" + Thread.currentThread().getName());
        //在主线程中创建并且启动三个分线程
        for (int i = 0;i < 3;i++) {
            new Thread(new Task()).start();
        }
    }

}
