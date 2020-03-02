package com.atguigu.pojo;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class Dom4jTest {
    @Test
    public void test1() throws Exception {
        // 创建一个SaxReader输入流，去读取 xml配置文件，生成Document对象
        SAXReader saxReader = new SAXReader();

        Document document = saxReader.read("src/books.xml");

        System.out.println(document);
    }

    @Test
    public void test2() throws Exception {
        //1.读取books.xml文件
        SAXReader reader = new SAXReader();
        //在Junit单元测试中，相对路径是从模块名开始算
        Document document = reader.read("./src/books.xml");

        //2.通过Document对象获取xml的根元素
        Element rootElement = document.getRootElement();
//        System.out.println(rootElement);

        //3.通过根元素获取book标签对象
        //element和elements方法都是通过标签名查找子元素
        List<Element> books = rootElement.elements("book");
        for (Element book : books) {
            //asXML方法是把标签对象转换为标签字符串
//            System.out.println(book.asXML());
            Element nameElement = book.element("name");
            //getText方法可以获取标签中的文本内容
            String nameText = nameElement.getText();
            System.out.println(nameText);

            //elementText直接获取指定标签的文本内容
            String authorText = book.elementText("author");
            String priceText = book.elementText("price");
            //attributeValue获取属性值
            String snValue = book.attributeValue("sn");
            System.out.println(new Book(snValue,nameText,new BigDecimal(Double.parseDouble(priceText)),authorText));
        }
    }

}
