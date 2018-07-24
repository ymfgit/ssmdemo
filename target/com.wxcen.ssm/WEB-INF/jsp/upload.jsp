<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-3-23
  Time: 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传页面</title>
</head>
<body>
<form action="/demo/file/upload" enctype="multipart/form-data" method="post">
    <table>
        <tr>
            <td>请选择文件:</td>
            <td><input type="file" name="file"></td>
        </tr>
        <tr>
            <td><input type="submit" value="上传"></td>
        </tr>
    </table>

    <a href="/demo/file/download">文件下载</a>
</form>
</body>
</html>
