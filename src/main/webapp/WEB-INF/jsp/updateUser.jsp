<%--
  Created by IntelliJ IDEA.
  User: 朱文强
  Date: 2024/3/13
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改用户信息</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/updateUserData" method="post" enctype="multipart/form-data">
        新的邮箱为：<input name="emailName" type="text">
        新的电话为：<input name="numberName" type="text">
        上传新的头像：<input type="file" name="img">
        <input type="submit" value="提交">
    </form>
</body>
</html>
