package com.qfedu.service.impl;

import com.qfedu.dao.UserDao;
import com.qfedu.dao.impl.UserDaoImpl;
import com.qfedu.entity.User;
import com.qfedu.service.UserService;
import com.qfedu.util.BaseDao;

import java.util.List;

public class UserServiceImpl extends BaseDao implements UserService {

    @Override
    public List<User> selectAll(int pageNo, int pageSize) {
        UserDao userDao = new UserDaoImpl();
        List<User> users = userDao.selectAll(pageNo, pageSize);

        return users;
    }

    @Override
    public int getAll() {
        UserDao userDao = new UserDaoImpl();
        int i = userDao.selectDataCount();
        return i;
    }
}
