package com.qfedu.controller;

import com.qfedu.service.UserService;
import com.qfedu.service.impl.UserServiceImpl;
import com.qfedu.util.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        UserService userService = new UserServiceImpl();
        String pN = request.getParameter("pageNo");
        if (pN == null) {
            pN = "1";
        }
        int pageNo = Integer.parseInt("pN");
        int pageSize = 3;

        int all = userService.getAll();

        PageUtil pageUtil = new PageUtil();
        pageUtil.setPageNo(pageNo);
        pageUtil.setPageSize(pageSize);
        pageUtil.setDataCount(all);
        pageUtil.setPageCount(pageNo);


    }
}
