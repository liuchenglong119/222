package com.qfedu.service.impl;

import com.qfedu.dao.StudentDao;
import com.qfedu.dao.impl.StudentDaoImpl;
import com.qfedu.entity.Student;
import com.qfedu.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    @Override
    public List<Student> getAll(int pageNo, int pageSize) {
        StudentDao studentDao = new StudentDaoImpl();
        List<Student> students = studentDao.selectAll(pageNo, pageSize);

        return students;
    }

    @Override
    public int getDataCount() {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        int i = studentDao.selectDataCount();
        return i;

    }
}
