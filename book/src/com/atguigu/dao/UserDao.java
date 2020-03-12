package com.atguigu.dao;

import com.atguigu.pojo.User;

/**
 * @author hskBeginner Email：2752962035@qq.com
 * @version 1.0
 * @description
 * @create 2020年03月04日 10时40分06秒
 */
public interface UserDao {

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return 如果返回null，说明没有这个用户。
     */
    public User queryUserByUsername(String username);

    /**
     * 根据用户名和密码查询用户
     *
     * @param username 用户名
     * @param password 密码
     * @return 如果返回null，表明用户名或者密码错误。
     */
    public User queryUserByUsernameAndPassword(String username, String password);

    /**
     * 注册用户
     *
     * @param user
     * @return
     */
    public Integer saveUser(User user);

}
