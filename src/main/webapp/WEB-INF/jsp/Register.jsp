
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>
        注册页面
    </title>
    <link href="css/register.css" rel="stylesheet">

    <style>
        .Code_msg{
            color: #C40000;
        }
    </style>

</head>
<body>

<%--用户名不存在，请先注册--%>
<c:if test="${!empty sessionScope.Register_msg1}">
    <script>alert("用户名太受欢迎，请换一个！")</script>
</c:if>


<c:if test="${!empty sessionScope.Register_msg2}">
    <script>alert("两次密码格式不一样，请重试！")</script>
</c:if>



<div class="form-div">
    <div class="reg-content">
        <h1>欢迎注册</h1>
        <span>已有帐号？</span> <a href="login.jsp">登录</a>
        <br>
        <br>
        <strong class="Code_msg">${register_msg}</strong>
    </div>
    <form id="reg-form" action="${pageContext.request.contextPath}/RegisterUser" method="get">

        <table>

            <tr>
                <td>用户名</td>
                <td class="inputs">
                    <input name="username" type="text" id="username">
                    <br>
                    <span id="username_err" class="err_msg" style="display: none">用户名太受欢迎，请换一个！</span>
                </td>

            </tr>

            <tr>
                <td>密码</td>
                <td class="inputs">
                    <input name="password" type="password" id="password">
                    <br>
                    <span id="password_err" class="err_msg" style="display: none">密码格式有误</span>
                </td>
            </tr>


            <tr>
                <td>确认密码</td>
                <td class="inputs">
                    <input name="password2" type="password" id="password2">
                    <br>
                    <span id="password_err2" class="err_msg" style="display: none">密码格式有误</span>
                </td>
            </tr>


            <tr>
                <td>验证码</td>
                <td class="inputs">
                    <input name="checkCode" type="text" id="checkCode">
                    <img src="${pageContext.request.contextPath}/checkCode" id="checkCodeImg">
                    <a href="#" id="changeImg">看不清？</a>
                </td>
            </tr>

        </table>

        <div class="buttons">
            <input value="注 册" type="submit" id="reg_btn">
        </div>
        <br class="clear">
    </form>
</div>

<script>
    document.getElementById("changeImg").onclick = function (){
        document.getElementById("checkCodeImg").src = "${pageContext.request.contextPath}/checkCode" + new Date().getMilliseconds();
    }
</script>

</body>
</html>
