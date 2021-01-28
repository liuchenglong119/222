package com.qfedu.dao;

import com.qfedu.entity.Student;

import java.util.List;

public interface StudentDao {
    public List<Student> selectAll(int pageNo, int pageSize);
    public int selectDataCount();
}
