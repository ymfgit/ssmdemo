<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>JSTL显示用户信息</title>
  </head>
  
  <body>

    <table cellspacing="10px" cellpadding="10px" align="center" style="background-color: silver;">
        <thead>
            <tr>
                <td>用户ID</td>
                <td>用户名</td>
                <td>用户密码</td>
                <td>用户年龄</td>
            </tr>
        </thead>
        <c:forEach items="${userInfoList}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.userName}</td>
                <td>${user.password}</td>
                <td>${user.age}</td>
            </tr>
        </c:forEach>
    </table>
  </body>
</html>
