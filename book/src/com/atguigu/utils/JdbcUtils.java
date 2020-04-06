package com.atguigu.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {

    //dataSource数据源，就相当于是一个数据库连接池对象，里面有很多个数据库连接对象
    //而且数据库连接池一般都是设计成单例的类
    private static DruidDataSource dataSource;

    private static ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<>();

    static {
        try {
            Properties properties = new Properties();
            // 读取 jdbc.properties属性配置文件
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            // 从流中加载数据
            properties.load(inputStream);
            // 创建 数据库连接 池
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);

//            System.out.println(dataSource.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

//    public static void main(String[] args) {
//
//    }

    /**
     * 获取数据库连接池中的连接
     *
     * @return 如果返回null, 说明获取连接失败<br />有值就是获取连接成功
     */
    public static Connection getConnection() {
//
//        Connection conn = null;
//
//        try {
//            conn = dataSource.getConnection();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return conn;

        Connection conn = connectionThreadLocal.get();
        if (conn == null) {
            try {
                conn = dataSource.getConnection();

                connectionThreadLocal.set(conn);//将该数据库连接对象保存到ThreadLocal对象中，供后面的JDBC操作使用

                conn.setAutoCommit(false);//设置手动管理事务
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;

    }

    /**
     * 提交事务，并且关闭释放数据库连接/jdbc连接
     */
    public static void commitAndClose(){
        Connection conn = connectionThreadLocal.get();
        if (conn != null) {//如果不等于null，说明之前使用过这个Connection连接对象操作过数据库

            try {
                conn.commit();//提交事务

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();//关闭数据库连接，释放系统资源
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            //一定要执行remove操作，否则出错（因为Tomcat服务器底层使用了线程池技术）
            connectionThreadLocal.remove();
        }
    }

    /**
     * 回滚事务，并且关闭释放数据库连接/jdbc连接
     */
    public static void rollbackAndClose(){
        Connection conn = connectionThreadLocal.get();
        if (conn != null) {//如果不等于null，说明之前使用过这个Connection连接对象操作过数据库

            try {
                conn.rollback();//提交事务

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();//关闭数据库连接，释放系统资源
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            //一定要执行remove操作，否则出错（因为Tomcat服务器底层使用了线程池技术）
            connectionThreadLocal.remove();
        }
    }

    /**
     * 原生的jdbc关闭连接指的是释放资源
     * 使用数据库连接池技术获取的数据库连接对象，关闭连接指的是将数据库连接对象放回数据库连接池中
     *
     * @param conn
     */
//    public static void close(Connection conn) {
//        if (conn != null) {
//            try {
//                conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }

}
