<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 朱文强
  Date: 2024/3/12
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>论坛</title>
</head>

<style>
    .header-row{
        /*border: 1px solid rgb(10, 10, 10);*/
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
    .main01{
        /*border: 1px solid rgb(10, 10, 10);*/
        float: left;
        margin-top: 5px;
        margin-left: 300px;
        height: 300px;
        width: 840px;
    }
    .main02{
        /*border: 1px solid rgb(10, 10, 10);*/
        float: left;
        margin-top: 5px;
        margin-left: 300px;
        height: 200px;
        width: 840px;
        background: #dfdfdf;
    }
    .main02-header{
        /*border: 1px solid rgb(10, 10, 10);*/
        float: left;
        height: 50px;
        width: 840px;
    }
    .main02-header-01{
        /*border: 1px solid rgb(10, 10, 10);*/
        float: left;
        height: 50px;
        width: 200px;
    }
    .main02-header-01-l{
        /*border: 1px solid rgb(10, 10, 10);*/
        float: left;
        height: 48px;
        width: 48px;
        margin-top: 2px;
        text-align: center;
    }
    .main02-header-01-r{
        /*border: 1px solid rgb(10, 10, 10);*/
        float: left;
        height: 25px;
        width: 100px;
        margin-top: 20px;
        margin-left: 30px;
        text-align: center;
    }
    .main02-header-02{
        /*border: 1px solid rgb(10, 10, 10);*/
        float: left;
        height: 100px;
        width: 840px;
    }
    .main02-header-02-l{
        /*border: 1px solid rgb(10, 10, 10);*/
        float: left;
        height: 100px;
        width: 200px;
    }
    .main02-header-02-r1{
        /*border: 1px solid rgb(10, 10, 10);*/
        float: left;
        margin-left: 10px;
        height: 25px;
        width: 620px;
    }
    .main02-header-02-r2{
        /*border: 1px solid rgb(10, 10, 10);*/
        float: left;
        margin-left: 10px;
        margin-top: 5px;
        height: 67px;
        width: 620px;
    }
    .main02-foot-l{
        /*border: 1px solid rgb(10, 10, 10);*/
        float: left;
        margin-left: 10px;
        margin-top: 10px;
        height: 25px;
        width: 90px;
        text-align: center;
    }
    .main02-foot-m{
        /*border: 1px solid rgb(10, 10, 10);*/
        float: left;
        margin-left: 200px;
        margin-top: 10px;
        height: 25px;
        width: 90px;
        text-align: center;
    }
    .main02-foot-r{
        /*border: 1px solid rgb(10, 10, 10);*/
        float: left;
        margin-left: 250px;
        margin-top: 10px;
        height: 25px;
        width: 90px;
        text-align: center;
    }
    .a{
        color: black;
        text-decoration: none;
    }
</style>

<body>

<div class="header-row">
    <div class="header-row1"><a href="${pageContext.request.contextPath}/goUserHome" class="a">首页</a></div>
    <div class="header-row2">

        <form method="get" action="${pageContext.request.contextPath}/getAllElement0">

        <div class="header-row2-01">
            <input name="keyword" value="">
        </div>
        <div class="header-row2-02">
            <input type="submit" value="搜索">
        </div>
        </form>
    </div>

    <div class="header-row3">
        <a href="${pageContext.request.contextPath}/goAddPost" class="a">写文章</a>
        &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
        <a href="${pageContext.request.contextPath}/goLoginUser" class="a">登录</a>
    </div>

</div>

<hr>

<div class="main01">
    <img src="${pageContext.request.contextPath}/img/slider-20200706001324_3.png" width="840">
</div>

<c:forEach items="${sessionScope.forumEleList}" var="forumEleList">
<div class="main02">
    <div class="main02-header">
        <div class="main02-header-01">
            <div class="main02-header-01-l"><img src="img/${forumEleList.user.img}" height="48px"></div>
            <div class="main02-header-01-r">${forumEleList.user.username}</div>
        </div>
    </div>


    <div class="main02-header-02">
        <div class="main02-header-02-l">
            <a href="http://localhost:8080/Project06_war//getPostDetail?postId=${forumEleList.post.id}">
                <img src="img/${forumEleList.post.img}" height="100px">
            </a>
        </div>
        <div class="main02-header-02-r1">
            <a href="http://localhost:8080/Project06_war//getPostDetail?postId=${forumEleList.post.id}" class="a">
                <strong>${forumEleList.post.post_name}</strong>
            </a>

        </div>
        <div class="main02-header-02-r2">
            <a href="http://localhost:8080/Project06_war//getPostDetail?postId=${forumEleList.post.id}" class="a">
                    ${forumEleList.post.post_content}
            </a>
        </div>
    </div>
    <div class="main02-foot-l">
        <a href="${pageContext.request.contextPath}/goPostDetail" class="a">
                ${forumEleList.commentNumber}条评论
        </a>
    </div>
    <div class="main02-foot-m">
        <a href="http://localhost:8080/Project06_war//addStar?postId=${forumEleList.post.id}"class="a">
            ★${forumEleList.star}
        </a>
    </div>
    <div class="main02-foot-r">
        <a href="http://localhost:8080/Project06_war//addZan?postId=${forumEleList.post.id}" class="a">
            ❤${forumEleList.post.zan}
        </a>
    </div>
</div>
</c:forEach>


</body>
</html>