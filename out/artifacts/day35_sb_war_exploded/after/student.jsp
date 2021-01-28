<%--
  Created by IntelliJ IDEA.
  User: wangbo
  Date: 2021/1/12
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table border="2" align="center" width="80%" bordercolor="red">
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>性别</th>
    </tr>
    <c:forEach var="stu" items="${students}">
        <tr>
            <td>${stu.id}</td>
            <td>${stu.name}</td>
            <td>${stu.age}</td>
            <td>${stu.sex}</td>
        </tr>
    </c:forEach>
    <%
        Object objNo = request.getAttribute("pageNo");
        Object objCount = request.getAttribute("pageCount");
        int pageNo = 0;
        int pageCount = 0;
        if (objNo != null) {
            pageNo = Integer.parseInt(objNo.toString());
        }
        if (objCount != null) {
            pageCount = Integer.parseInt(objCount.toString());
        }

    %>
    <tr>
        <td colspan="4">
            <a href="<%=path%>/StudentServlet?pageNo=1">首页</a>
            <%
                if (pageNo > 1) {
            %>
            <a href="<%=path%>/StudentServlet?pageNo=${pageNo-1}">上一页</a>
            <%
                }
                if (pageNo == 1) {
            %>
            <a>上一页</a>
            <%
                }
            %>
            <%
                if(pageCount > pageNo) {
            %>
            <a href="<%=path%>/StudentServlet?pageNo=${pageNo+1}">下一页</a>
            <%
                }
                if (pageCount == pageNo) {
            %>
            <a>下一页</a>
            <%
                }
            %>
            <a href="<%=path%>/StudentServlet?pageNo=${pageCount}">尾页</a>


        </td>
    </tr>
</table>
</body>
</html>
