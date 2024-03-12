<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<style>
    html {
        height: 100%;
    }
    body {
        margin: 0;
        padding: 0;
        font-family: sans-serif;
        background: linear-gradient(#141e30, #243b55);
    }
    .my-login-box {
        position: absolute;
        top: 50%;
        left: 50%;
        width: 400px;
        padding: 40px;
        transform: translate(-50%, -50%);
        background: rgba(0, 0, 0, .5);
        box-sizing: border-box;
        box-shadow: 0 15px 25px rgba(0, 0, 0, .6);
        border-radius: 10px;
    }
    .my-login-box h2 {
        margin: 0 0 30px;
        padding: 0;
        color: #fff;
        text-align: center;
    }
    .my-login-box .user-box {
        position: relative;
    }
    .my-login-box .user-box input {
        width: 100%;
        padding: 10px 0;
        font-size: 16px;
        color: #fff;
        margin-bottom: 30px;
        border: none;
        border-bottom: 1px solid #fff;
        outline: none;
        background: transparent;
    }
    .my-login-box .user-box label {
        position: absolute;
        top: 0;
        left: 0;
        padding: 10px 0;
        font-size: 16px;
        color: #fff;
        pointer-events: none;
        transition: .5s;
    }
    .my-login-box .user-box input:focus ~ label,
    .my-login-box .user-box input:valid ~ label {
        top: -30px;
        left: 0;
        color: #03e9f4;
        font-size: 12px;
    }
    .my-login-box form a {
        position: relative;
        display: inline-block;
        padding: 10px 20px;
        color: #03e9f4;
        font-size: 16px;
        text-decoration: none;
        text-transform: uppercase;
        overflow: hidden;
        transition: .5s;
        margin-top: 40px;
        letter-spacing: 4px
    }
    .my-login-box a:hover {
        background: #03e9f4;
        color: #fff;
        border-radius: 5px;
        box-shadow: 0 0 5px #03e9f4, 0 0 25px #03e9f4, 0 0 50px #03e9f4, 0 0 100px #03e9f4;
    }
    .my-login-box a span {
        position: absolute;
        display: block;
    }
    .my-login-box a span:nth-child(1) {
        top: 0;
        left: -100%;
        width: 100%;
        height: 2px;
        background: linear-gradient(90deg, transparent, #03e9f4);
        animation: btn-anim1 1s linear infinite;
    }
    @keyframes btn-anim1 {
        0% {
            left: -100%;
        }
        50%,
        100% {
            left: 100%;
        }
    }
    .my-login-box a span:nth-child(2) {
        top: -100%;
        right: 0;
        width: 2px;
        height: 100%;
        background: linear-gradient(180deg, transparent, #03e9f4);
        animation: btn-anim2 1s linear infinite;
        animation-delay: .25s
    }
    @keyframes btn-anim2 {
        0% {
            top: -100%;
        }
        50%,
        100% {
            top: 100%;
        }
    }
    .my-login-box a span:nth-child(3) {
        bottom: 0;
        right: -100%;
        width: 100%;
        height: 2px;
        background: linear-gradient(270deg, transparent, #03e9f4);
        animation: btn-anim3 1s linear infinite;
        animation-delay: .5s
    }
    @keyframes btn-anim3 {
        0% {
            right: -100%;
        }
        50%,
        100% {
            right: 100%;
        }
    }
    .my-login-box a span:nth-child(4) {
        bottom: -100%;
        left: 0;
        width: 2px;
        height: 100%;
        background: linear-gradient(360deg, transparent, #03e9f4);
        animation: btn-anim4 1s linear infinite;
        animation-delay: .75s
    }
    @keyframes btn-anim4 {
        0% {
            bottom: -100%;
        }
        50%,
        100% {
            bottom: 100%;
        }
    }

</style>

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


<body>
<%--<h3>--%>
<%--    <a href="${pageContext.request.contextPath}/goLoginUser">进入线性代数后台管理系统</a>--%>
<%--</h3>--%>
<script type="text/javascript">
    function submit(){
        $("#click").submit();
    }
</script>

<div class="my-login-box">
    <h2>Login</h2>
    <form method="post" action="${pageContext.request.contextPath}/loginUser" id="click">
        <div class="user-box">
            <input type="text" name="username" id="username">
            <label>Username</label>
        </div>
        <div class="user-box">
            <input type="password" name="password" id="password">
            <label>Password</label>
        </div>

        <span></span>
        <span></span>
        <span></span>
        <span></span>
        <a href="#" onclick="document.getElementById('click').submit();return false;">Submit</a>
        <a href="${pageContext.request.contextPath}/goRegisterUser">没有账号？</a>
    </form>
</div>












</body>
</html>



















