package com.atguigu.test;

import org.junit.Test;

/**
 * @author hskBeginner Email：2752962035@qq.com
 * @version 1.0
 * @description
 * @create 2020年03月18日
 */
public class PersonTest {

    //wait方法必须在同步代码块或者同步方法中使用，否则有java.lang.IllegalMonitorStateException异常
    @Test
    public void test1(){
        Person p = new Person();
        try {
            p.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
