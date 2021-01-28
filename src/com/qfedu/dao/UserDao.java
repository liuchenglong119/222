package com.qfedu.dao;

import com.qfedu.entity.User;

import java.util.List;

public interface UserDao {
    public List<User> selectAll(int pageNo, int pageSize);
    public int selectDataCount();
}
