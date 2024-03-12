
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">

    <title>登录界面</title>
    <link href="css/login.css" rel="stylesheet">


    <%--用户名不存在，请先注册--%>
    <c:if test="${!empty sessionScope.usernameError}">
        <script>alert("账号不存在，请先注册！")</script>
    </c:if>

    <%--密码错误--%>
    <c:if test="${!empty sessionScope.passwordError}">
        <script>alert("密码错误，请重试")</script>
    </c:if>


    <c:if test="${!empty sessionScope.Register_msg3}">
        <script>alert("注册成功！")</script>
    </c:if>

</head>
<body>


<div id="loginDiv" style="height: 350px">
    <form action="${pageContext.request.contextPath}/loginUser" id="form" method="post">
        <h1 id="loginMsg">登录页面</h1>
        <%--        <div id="errorMsg">用户名或密码不正确</div>--%>
        <p>账号:<input id="username" name="username" type="text"></p>

        <p>密码:<input id="password" name="password" type="password"></p>
        <p>记住我:<input id="remember" name="remember" type="checkbox"></p>
        <div id="subDiv">
            <input type="submit" class="button" value="登录">
            <input type="reset" class="button" value="清空">&nbsp;&nbsp;
            <a href="${pageContext.request.contextPath}/goRegisterUser">没有账号？</a>
        </div>
    </form>
</div>


</body>
</html>
