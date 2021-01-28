package com.qfedu.controller;

import com.qfedu.entity.Student;
import com.qfedu.service.StudentService;
import com.qfedu.service.impl.StudentServiceImpl;
import com.qfedu.util.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        StudentService studentService = new StudentServiceImpl();
//        PageUtil pageUtil = new PageUtil();
        //这是判断当没有下一页时
        String pNo = request.getParameter("pageNo");//
        if (pNo == null) {
            pNo = "1";
        }
        int pageNo = Integer.parseInt(pNo);//把字符串转换成int类型，这是一个新方法记者就行
//        int pageNo = Integer.parseInt(pNo);//把字符串转换成int类型，这是一个新方法记者就行
        //这是定义pageSize以几个为一页
        int pageSize = 3;
        //
        int dataCount = studentService.getDataCount();//获取数据库的总条数

        //获取总页数
        PageUtil pageUtil = new PageUtil();
        pageUtil.setPageNo(pageNo);
        pageUtil.setPageSize(pageSize);
        pageUtil.setDataCount(dataCount);
        int pageCount = pageUtil.getPageCount();

        //下面是转发到前端
        List<Student> students = studentService.getAll(pageNo,pageSize);
        request.setAttribute("students",students);
        request.setAttribute("pageNo",pageNo);
        request.setAttribute("pageSize",pageSize);
        request.setAttribute("pageCount",pageCount);
        request.getRequestDispatcher("/after/student.jsp").forward(request,response);

    }
}
