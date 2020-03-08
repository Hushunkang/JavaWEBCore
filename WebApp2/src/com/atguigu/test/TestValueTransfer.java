package com.atguigu.test;

import org.junit.Test;

/**
 * @author hskBeginner Email：2752962035@qq.com
 * @version 1.0
 * @description
 * @create 2020年03月08日 23时55分39秒
 */
public class TestValueTransfer {

    Person p = new Person("tom",18);

    @Test
    public void test1(){

        changePerson(p);

        System.out.println(p);

    }

    private void changePerson(Person p){
//        p = new Person("jack",20);
        p.setName("jack");
        p.setAge(20);
    }

}

class Person{

    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
