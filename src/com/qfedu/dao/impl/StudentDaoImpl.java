package com.qfedu.dao.impl;

import com.qfedu.dao.StudentDao;
import com.qfedu.entity.Student;
import com.qfedu.util.BaseDao;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public class StudentDaoImpl extends BaseDao implements StudentDao {
    @Override
    public List<Student> selectAll(int pageNo, int pageSize) {
        String sql = "select * from student limit ?,?";
        Object[] obj = {(pageNo-1)*pageSize,pageSize};
        try {
            List<Student> students = super.query(sql, obj, Student.class);
            System.out.println(students);
            return students;
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
        String sql = "select * from student";
        Object[] obj = {};
        try {
            List<Student> count = super.query(sql, obj, Student.class);
            return count.size();
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
