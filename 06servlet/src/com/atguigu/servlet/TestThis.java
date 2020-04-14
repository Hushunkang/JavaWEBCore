package com.atguigu.servlet;

import org.junit.Test;

/**
 * @author hskBeginner Email：2752962035@qq.com
 * @version 1.0
 * @description
 * @create 2020年03月03日
 */
public class TestThis extends TestThisPojoSuper{//TestThisPojoSuper是一个普通的Java类

    @Test
    public void test1(){
        System.out.println(this);//com.atguigu.servlet.TestThis@1b4fb997
//        System.out.println(super);//super不可以单独使用，因为它并不是表示一个类的一个实例
        System.out.println(this.getClass());//class com.atguigu.servlet.TestThis
        System.out.println(super.getClass());//class com.atguigu.servlet.TestThis
    }

}
