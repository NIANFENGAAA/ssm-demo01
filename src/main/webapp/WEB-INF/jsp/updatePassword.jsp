<%--
  Created by IntelliJ IDEA.
  User: 朱文强
  Date: 2024/3/16
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>修改密码</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/updatePassword" method="post">
        <a href="${pageContext.request.contextPath}/goUserHome">首页</a>
        请输入新的密码：
        <input name="newPassword" type="text">
        请重复新的密码：
        <input name="newPassword2" type="text">
        <input type="submit" value="提交">
    </form>
</body>
</html>
