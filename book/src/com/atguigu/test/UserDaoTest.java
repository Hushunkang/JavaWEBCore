package com.atguigu.test;

import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.pojo.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author hskBeginner Email：2752962035@qq.com
 * @version 1.0
 * @description
 * @create 2020年03月04日
 */
public class UserDaoTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    UserDao userDao = new UserDaoImpl();

    @Test
    public void queryUserByUsername() {
        User user = userDao.queryUserByUsername("admin123");
//        System.out.println(user);

        if (user == null) {
            System.out.println("用户名可用");
        } else {
            System.out.println("用户名不可用");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        User user = userDao.queryUserByUsernameAndPassword("admin123", "admin");

        if (user == null) {
            System.out.println("用户名或者密码错误，登录失败");
        } else {
            System.out.println("找到了这个用户，登录成功");
        }
    }

    @Test
    public void saveUser() {
        Integer affectRow = userDao.saveUser(new User(null, "admin123", "admin", "admin123@guigu.com"));
        System.out.println(affectRow);
    }

}