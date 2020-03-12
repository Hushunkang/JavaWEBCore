package com.atguigu.dao.impl;

import com.atguigu.dao.UserDao;
import com.atguigu.pojo.User;

/**
 * @author hskBeginner Email：2752962035@qq.com
 * @version 1.0
 * @description
 * @create 2020年03月04日 10时48分53秒
 */
public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public User queryUserByUsername(String username) {
        String sql = "select `id`,`username`,`password`,`email` from t_user where username=?";

        return queryForOne(User.class, sql, username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select `id`,`username`,`password`,`email` from t_user where username=? and password=?";

        return queryForOne(User.class, sql, username, password);
    }

    @Override
    public Integer saveUser(User user) {
        String sql = "insert into t_user(`username`,`password`,`email`) values(?,?,?)";

        return update(sql, user.getUsername(), user.getPassword(), user.getEmail());
    }

}
