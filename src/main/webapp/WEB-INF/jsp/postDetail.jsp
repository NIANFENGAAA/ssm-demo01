<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 朱文强
  Date: 2024/3/12
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<style>
    .all{
        height: 100%;
        width: 100%;
        background: #4b484a;
    }
    .header-row{
        border: 1px solid rgb(10, 10, 10);
        float: left;
        height: 50px;
        width: 100%;
    }
    .header-row1{
        /*border: 1px solid rgb(10, 10, 10);*/
        float: left;
        margin-top: 8px;
        margin-left: 300px;
        height: 30px;
        width: 60px;
        text-align: center;
    }
    .header-row2{
        /*border: 1px solid rgb(10, 10, 10);*/
        float: left;
        margin-top: 3px;
        margin-left: 25px;
        height: 45px;
        width: 300px;
    }
    .header-row2-01{
        /*border: 1px solid rgb(10, 10, 10);*/
        float: left;
        margin-top: 6px;
        margin-left: 5px;
        height: 25px;
        width: 215px;
        text-align: center;
    }
    .header-row2-02{
        /*border: 1px solid rgb(10, 10, 10);*/
        float: left;
        margin-top: 6px;
        margin-left: 2px;
        height: 25px;
        width: 65px;
        text-align: center;
    }
    .header-row3{
        /*border: 1px solid rgb(10, 10, 10);*/
        float: left;
        margin-top: 8px;
        margin-left: 50px;
        height: 30px;
        width: 400px;
    }
    .main{
        border: 1px solid rgb(10, 10, 10);
        float: left;
        height: 650px;
        width: 800px;
        margin-top: 5px;
        margin-left: 300px;

    }
    .main-header01{
        /*border: 1px solid rgb(10, 10, 10);*/
        float: left;
        height: 40px;
        width: 40px;
        margin-top: 20px;
        margin-left: 20px;
    }
    .main-header02{
        /*border: 1px solid rgb(10, 10, 10);*/
        float: left;
        height: 20px;
        width: 100px;
        margin-top: 40px;
        margin-left: 20px;
    }
    .main-header03{
        /*border: 1px solid rgb(10, 10, 10);*/
        float: left;
        height: 50px;
        width: 780px;
        margin-top: 5px;
        margin-left: 10px;
    }
    .main-header04{
        /*border: 1px solid rgb(10, 10, 10);*/
        float: left;
        height: 350px;
        width: 780px;
        margin-top: 10px;
        margin-left: 10px;
    }
    .main-header05{
        /*border: 1px solid rgb(10, 10, 10);*/
        float: left;
        height: 100px;
        width: 780px;
        margin-top: 10px;
        margin-left: 10px;
    }
    .main-header06-l{
        /*border: 1px solid rgb(10, 10, 10);*/
        float: left;
        height: 30px;
        width: 100px;
        margin-top: 10px;
        margin-left: 20px;
        text-align: center;
    }
    .main-header06-m{
        /*border: 1px solid rgb(10, 10, 10);*/
        float: left;
        height: 30px;
        width: 100px;
        margin-top: 10px;
        margin-left: 200px;
        text-align: center;
    }
    .main-header06-r{
        /*border: 1px solid rgb(10, 10, 10);*/
        float: left;
        height: 30px;
        width: 100px;
        margin-top: 10px;
        margin-left: 200px;
        text-align: center;
    }
    .comment{
        border: 1px solid rgb(10, 10, 10);
        float: left;
        height: 120px;
        width: 780px;
        margin-top: 25px;
        margin-left: 10px;
    }
    .comment-up01{
        /*border: 1px solid rgb(10, 10, 10);*/
        float: left;
        height: 40px;
        width: 40px;
        margin-top: 10px;
        margin-left: 10px;
    }
    .comment-up02{
        /*border: 1px solid rgb(10, 10, 10);*/
        float: left;
        height: 30px;
        width: 700px;
        margin-top: 20px;
        margin-left: 10px;
    }
    .comment-footer{
        /*border: 1px solid rgb(10, 10, 10);*/
        float: left;
        height: 60px;
        width: 700px;
        margin-top: 5px;
        margin-left: 60px;
    }
    .a{
        color: black;
        text-decoration: none;
    }
    .foot_comment{
        /*border: 1px solid rgb(10, 10, 10);*/
        float: left;
        height: 500px;
        width: 780px;
        margin-top: 5px;
        margin-left: 10px;
    }
    .input_type{
        height: 35px;
        width: 700px;
        margin-top: 3px;
        float: left;
    }
    .comment_type{
        margin-top: 10px;
        margin-left: 10px;
    }
</style>

<body>
<div class="all">

<div class="header-row">
    <div class="header-row1"><a href="${pageContext.request.contextPath}/goNewForum" class="a">返回</a> </div>
    <div class="header-row2">
        <div class="header-row2-01">
            <input type="text">
        </div>
        <div class="header-row2-02">
            <input type="button" value="搜索">
        </div>
    </div>
    <div class="header-row3">
        <a href="${pageContext.request.contextPath}/goAddPost" class="a">写文章</a>
        &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
        <a href="${pageContext.request.contextPath}/goLoginUser" class="a">登录</a>
    </div>
</div>



<div class="main">
    <div class="main-header01">
        <img src="img/${sessionScope.postDetailEle.user.img}" height="40px">
    </div>
    <div class="main-header02">
        ${sessionScope.postDetailEle.user.username}
    </div>
    <div class="main-header03">
        <h2>${sessionScope.postDetailEle.post.post_name}</h2>
    </div>
    <div class="main-header04">
        <img src="img/${sessionScope.postDetailEle.post.img}" height="350px">
    </div>
    <div class="main-header05">
            ${sessionScope.postDetailEle.post.post_content}
    </div>
    <div class="main-header06-l">
            ${sessionScope.postDetailEle.comments.size()}条评论
    </div>
    <div class="main-header06-r">
        <a href="http://localhost:8080/Project06_war//addStar?postId=${sessionScope.postDetailEle.post.id}"class="a">
            ★${sessionScope.postDetailEle.star}
        </a>

    </div>
    <div class="main-header06-m">
        <a href="http://localhost:8080/Project06_war//addZan?postId=${sessionScope.postDetailEle.post.id}" class="a">
            ❤${sessionScope.postDetailEle.post.zan}
        </a>

    </div>


    <c:forEach items="${sessionScope.postDetailEle.comments}" var="comment">
    <div class="comment">
        <div class="comment-up01">
            <img src="img/${comment.user.img}" height="40px">
        </div>
        <div class="comment-up02">
                ${comment.user.username}
        </div>
        <div class="comment-footer">
                ${comment.comment_content}
        </div>
    </div>
    </c:forEach>

    <div class="foot_comment">
        <form method="post" action="http://localhost:8080/Project06_war//addComment?postId=${sessionScope.postDetailEle.post.id}" >
            <input type="text" class="input_type" name="commentName">
            <input type="submit" value="评论" class="comment_type">

        </form>
    </div>

</div>


</div>
</body>
</html>