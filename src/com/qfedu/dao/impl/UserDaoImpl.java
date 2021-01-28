package com.qfedu.dao.impl;

import com.qfedu.dao.UserDao;
import com.qfedu.entity.User;
import com.qfedu.util.BaseDao;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public List<User> selectAll(int pageNo, int pageSize) {
        String sql = "select * from User limit ?,?";
        Object[] obj = {(pageNo - 1)*pageSize, pageSize};
        try {
            List<User> query = super.query(sql, obj, User.class);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int selectDataCount() {
        String sql = "select * from User";
        Object[] obj = {};
        try {
            List<User> cont = super.query(sql, obj, User.class);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
