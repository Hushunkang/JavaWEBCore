package com.atguigu.test;

import org.junit.Test;

import java.io.*;

/**
 * @author hskBeginner Email：2752962035@qq.com
 * @version 1.0
 * @description
 * @create 2020年03月07日
 */
public class TestCRLF {

    @Test
    public void test1() {
        File file = new File("resources/1.txt");
        try {
            FileInputStream fis = new FileInputStream(file);
            //获取字节流里面总共有多少个字节
            int count1 = fis.available();
            byte[] b = new byte[count1];
            fis.read(b);
            String a = new String(b);
            int m = a.length();
            System.out.println(m);
            for (int i = 0; i < m; i++) {
                if (a.charAt(i) == '\r') {
                    System.out.print("\\r");
                    continue;
                }
                if (a.charAt(i) == '\n') {
                    System.out.print("\\n");
                    continue;
                }
                System.out.print(a.charAt(i));
            }
            System.out.println();
            System.out.println(a.replaceAll("\r\n", ""));
            System.out.println(a.replaceAll("\n", ""));

            BufferedReader br = new BufferedReader(new FileReader(new File("resources/1.txt")));
            char[] cbuff = new char[1024];
            br.read(cbuff);
            String c = new String(cbuff);
            int n = a.length();
            System.out.println(n);
            for (int i = 0; i < n; i++) {
                if (a.charAt(i) == '\r') {
                    System.out.print("\\r");
                    continue;
                }
                if (a.charAt(i) == '\n') {
                    System.out.print("\\n");
                    continue;
                }
                System.out.print(a.charAt(i));
            }
            System.out.println();
            System.out.println(a.replaceAll("\r\n", ""));
            System.out.println(a.replaceAll("\n", ""));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

