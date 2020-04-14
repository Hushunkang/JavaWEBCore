package com.atguigu.test;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author hskBeginner Email：2752962035@qq.com
 * @version 1.0
 * @description
 * @create 2020年03月19日
 */
public class CartTest {

    @Test
    public void addItem() {
        Cart cart = new Cart();

        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2, "数据结构与算法", 1, new BigDecimal(100),new BigDecimal(100)));

        System.out.println(cart);

    }

    @Test
    public void deleteItem() {

        Cart cart = new Cart();

        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2, "数据结构与算法", 1, new BigDecimal(100),new BigDecimal(100)));

        cart.deleteItem(1);

        System.out.println(cart);

    }

    @Test
    public void clear() {
        Cart cart = new Cart();

        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2, "数据结构与算法", 1, new BigDecimal(100),new BigDecimal(100)));

        cart.deleteItem(1);

        cart.clear();

        System.out.println(cart);
    }

    @Test
    public void updateCount() {

        Cart cart = new Cart();

        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2, "数据结构与算法", 1, new BigDecimal(100),new BigDecimal(100)));

        cart.deleteItem(1);

        cart.clear();

        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(1000),new BigDecimal(1000)));

        cart.updateCount(1, 10);


        System.out.println(cart);

    }

    @Test
    public void test1(){
        int a = 0;
        int b = 1;
        while (true){
            while (b > a)
                System.out.println("b > a");
            if(b < a){
                System.out.println("b < a");
                break;
            }
        }
    }

    @Test
    public void test2(){
        Cart cart1 = new Cart();
        Cart cart2 = new Cart();
        System.out.println(cart1.getItems() == cart2.getItems());//false
    }

}