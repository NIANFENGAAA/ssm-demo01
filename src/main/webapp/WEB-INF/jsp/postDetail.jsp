<%--
  Created by IntelliJ IDEA.
  User: 朱文强
  Date: 2024/3/12
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<style>
    .header-row{
        border: 1px solid rgb(10, 10, 10);
        float: left;
        height: 50px;
        width: 100%;
    }
    .header-row1{
        border: 1px solid rgb(10, 10, 10);
        float: left;
        margin-top: 8px;
        margin-left: 300px;
        height: 30px;
        width: 60px;
        text-align: center;
    }
    .header-row2{
        border: 1px solid rgb(10, 10, 10);
        float: left;
        margin-top: 3px;
        margin-left: 25px;
        height: 45px;
        width: 300px;
    }
    .header-row2-01{
        border: 1px solid rgb(10, 10, 10);
        float: left;
        margin-top: 6px;
        margin-left: 5px;
        height: 25px;
        width: 215px;
        text-align: center;
    }
    .header-row2-02{
        border: 1px solid rgb(10, 10, 10);
        float: left;
        margin-top: 6px;
        margin-left: 2px;
        height: 25px;
        width: 65px;
        text-align: center;
    }
    .header-row3{
        border: 1px solid rgb(10, 10, 10);
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
        border: 1px solid rgb(10, 10, 10);
        float: left;
        height: 40px;
        width: 40px;
        margin-top: 20px;
        margin-left: 20px;
    }
    .main-header02{
        border: 1px solid rgb(10, 10, 10);
        float: left;
        height: 20px;
        width: 100px;
        margin-top: 40px;
        margin-left: 20px;
    }
    .main-header03{
        border: 1px solid rgb(10, 10, 10);
        float: left;
        height: 50px;
        width: 780px;
        margin-top: 5px;
        margin-left: 10px;
    }
    .main-header04{
        border: 1px solid rgb(10, 10, 10);
        float: left;
        height: 350px;
        width: 780px;
        margin-top: 10px;
        margin-left: 10px;
    }
    .main-header05{
        border: 1px solid rgb(10, 10, 10);
        float: left;
        height: 100px;
        width: 780px;
        margin-top: 10px;
        margin-left: 10px;
    }
    .main-header06-l{
        border: 1px solid rgb(10, 10, 10);
        float: left;
        height: 30px;
        width: 100px;
        margin-top: 10px;
        margin-left: 20px;
        text-align: center;
    }
    .main-header06-m{
        border: 1px solid rgb(10, 10, 10);
        float: left;
        height: 30px;
        width: 100px;
        margin-top: 10px;
        margin-left: 200px;
        text-align: center;
    }
    .main-header06-r{
        border: 1px solid rgb(10, 10, 10);
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
        border: 1px solid rgb(10, 10, 10);
        float: left;
        height: 40px;
        width: 40px;
        margin-top: 10px;
        margin-left: 10px;
    }
    .comment-up02{
        border: 1px solid rgb(10, 10, 10);
        float: left;
        height: 30px;
        width: 700px;
        margin-top: 20px;
        margin-left: 10px;
    }
    .comment-footer{
        border: 1px solid rgb(10, 10, 10);
        float: left;
        height: 60px;
        width: 700px;
        margin-top: 5px;
        margin-left: 60px;
    }
</style>

<body>

<div class="header-row">
    <div class="header-row1">首页</div>
    <div class="header-row2">
        <div class="header-row2-01">
            <input type="text">
        </div>
        <div class="header-row2-02">
            <input type="button" value="搜索">
        </div>
    </div>
    <div class="header-row3">
        <a href="#">写文章</a>
        &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
        <a href="#">登录</a>
    </div>
</div>

<div class="main">
    <div class="main-header01">
        头像
    </div>
    <div class="main-header02">
        用户名
    </div>
    <div class="main-header03">
        <h2>文章标题</h2>
    </div>
    <div class="main-header04">
        文章图片
    </div>
    <div class="main-header05">
        文章内容
    </div>
    <div class="main-header06-l">
        几条评论
    </div>
    <div class="main-header06-r">
        ★数量
    </div>
    <div class="main-header06-m">
        ❤点赞数
    </div>
    <div class="comment">
        <div class="comment-up01">
            头像
        </div>
        <div class="comment-up02">
            评论者id
        </div>
        <div class="comment-footer">
            评论内容
        </div>
    </div>
</div>

</body>
</html>