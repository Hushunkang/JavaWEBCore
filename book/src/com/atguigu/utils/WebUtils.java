package com.atguigu.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

public class WebUtils {
    /**
     * 把Map中的值注入到对应的JavaBean属性中。
     * @param value
     * @param bean
     * 说明，这个方法的第一个参数其实用HttpServletRequest也可以，只是没Map好
     * 因为，使用HttpServletRequest和Control层的耦合度太高了，Service层和Dao层并没有这个API，在这两层中，这种方法就不能用了
     * 使用Map代码适用范围更好，耦合性更低，扩展性更强，使用更加灵活
     * 用Map这个方法可以在Dao层使用，也可以在Service层使用，也可以在Control层使用
     */
    public static <T> T copyParamToBean( Map value , T bean ){
        try {
            System.out.println("注入之前：" + bean);
            /**
             * 把所有请求的参数都注入到user对象中
             */
            BeanUtils.populate(bean, value);
            System.out.println("注入之后：" + bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

}
