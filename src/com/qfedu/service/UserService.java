package com.qfedu.service;

import com.qfedu.entity.User;

import java.util.List;

public interface UserService {
    public List<User> selectAll(int pageNo,int pageSize);
    public int getAll();
}
