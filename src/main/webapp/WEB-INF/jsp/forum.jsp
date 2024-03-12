<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 朱文强
  Date: 2024/3/9
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎来到线性代数论坛交流平台</title>
</head>
<style>
    .header1{
        border: 1px solid rgb(10, 10, 10);
        float: left;
        height: 50px;
        width: 100%;
        text-align: center;
    }
    .header2{
        border: 1px solid rgb(10, 10, 10);
        float: left;
        width: 100%;
        height: 50px;
        margin-top: 5px;
        text-align: center;
    }
    .main{
        border: 1px solid rgb(10, 10, 10);
        /*text-align: center;*/
        margin-top: 10px;
        height: 300px;
        width: 500px;
        margin-left: 500px;
        float: left;
    }
    .main1{
        border: 1px solid rgb(10, 10, 10);
        float: left;
        width: 500px;
        height: 30px;
    }
    .main2{
        border: 1px solid rgb(10, 10, 10);
        float: left;
        width: 500px;
        height: 270px;
    }
    .main2_l{
        border: 1px solid rgb(10, 10, 10);
        float: left;
        width: 245px;
        height: 240px;
    }
    .main2_r{
        border: 1px solid rgb(10, 10, 10);
        float: left;
        margin-left: 5px;
        width: 245px;
        height: 240px;
        align-content: center;
    }
    .main_foot_r{
        border: 1px solid rgb(10, 10, 10);
        float: right;
        margin-right: 100px;
        margin-top: 2px;
        width: 50px;
        height: 25px;
    }
    .main_foot_l{
        border: 1px solid rgb(10, 10, 10);
        float: left;
        margin-left: 50px;
        margin-top: 2px;
        width: 50px;
        height: 25px;
    }
</style>
<body>

<script src="js/vue.js"></script>
<script src="js/axios-0.18.0.js"></script>
<script src="element-ui/lib/index.js"></script>
<link rel="stylesheet" href="element-ui/lib/theme-chalk/index.css" >

<link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
<script src="https://cdn.jsdelivr.net/npm/vue@2/dist/vue.js"></script>
<script src="https://unpkg.com/element-ui/lib/index.js"></script>



<div class="header1">
    <h4 style=" color: black;">欢迎来到线性代数论坛交流平台</h4>
</div>
<div class="header2">
    <input name="postName" value="">
    <input type="button" value="搜索">
</div>

<c:forEach items="${sessionScope.posts}" var="post">

    <div class="main">
        <div class="main1">
            ${sessionScope.username}: ${post.post_name}
        </div>
        <div class="main2">
            <div class="main2_l">
                    ${post.post_content}
            </div>
            <div class="main2_r">
<%--                图片--%>
                <img src="img/${post.img}" height="120px">
            </div>
            <div class="main_foot_l">
                评论
            </div>
            <div class="main_foot_r">
                    ${post.zan}
                <a href="http://localhost:8080/Project06_war//addZan?postId=${post.id}">
                    赞
<%--                    <i class="el-icon-caret-top"></i>--%>
                </a>
            </div>
        </div>
    </div>

</c:forEach>


</body>
</html>
