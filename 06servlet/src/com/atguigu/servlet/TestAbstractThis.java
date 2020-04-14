package com.atguigu.servlet;

import org.junit.Test;

/**
 * @author hskBeginner Email：2752962035@qq.com
 * @version 1.0
 * @description
 * @create 2020年03月03日
 */
public abstract class TestAbstractThis {

    @Test
    public void test1(){
        System.out.println(this);//java.lang.InstantiationException
//        System.out.println(super);//super不可以单独使用，因为它并不是表示一个类的一个实例
    }

}
