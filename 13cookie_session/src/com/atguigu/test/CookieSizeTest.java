package com.atguigu.test;

import org.junit.Test;

/**
 * @author hskBeginner Email：2752962035@qq.com
 * @version 1.0
 * @description
 * @create 2020年03月18日
 */
public class CookieSizeTest {

    @Test
    public void test1(){
        StringBuilder sb = new StringBuilder("JSESSIONID");
        sb.append("C892C1CE69449D4843671326D645E191");
        System.out.println(sb.length());//42
    }

}
