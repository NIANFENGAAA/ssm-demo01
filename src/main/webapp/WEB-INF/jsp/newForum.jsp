<%--
  Created by IntelliJ IDEA.
  User: 朱文强
  Date: 2024/3/12
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>论坛</title>
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
    .main01{
        border: 1px solid rgb(10, 10, 10);
        float: left;
        margin-top: 5px;
        margin-left: 300px;
        height: 300px;
        width: 840px;
    }
    .main02{
        border: 1px solid rgb(10, 10, 10);
        float: left;
        margin-top: 5px;
        margin-left: 300px;
        height: 200px;
        width: 840px;
    }
    .main02-header{
        border: 1px solid rgb(10, 10, 10);
        float: left;
        height: 50px;
        width: 840px;
    }
    .main02-header-01{
        border: 1px solid rgb(10, 10, 10);
        float: left;
        height: 50px;
        width: 200px;
    }
    .main02-header-01-l{
        border: 1px solid rgb(10, 10, 10);
        float: left;
        height: 48px;
        width: 48px;
        margin-top: 2px;
        text-align: center;
    }
    .main02-header-01-r{
        border: 1px solid rgb(10, 10, 10);
        float: left;
        height: 25px;
        width: 100px;
        margin-top: 20px;
        margin-left: 30px;
        text-align: center;
    }
    .main02-header-02{
        border: 1px solid rgb(10, 10, 10);
        float: left;
        height: 100px;
        width: 840px;
    }
    .main02-header-02-l{
        border: 1px solid rgb(10, 10, 10);
        float: left;
        height: 100px;
        width: 200px;
    }
    .main02-header-02-r1{
        border: 1px solid rgb(10, 10, 10);
        float: left;
        margin-left: 10px;
        height: 25px;
        width: 620px;
    }
    .main02-header-02-r2{
        border: 1px solid rgb(10, 10, 10);
        float: left;
        margin-left: 10px;
        margin-top: 5px;
        height: 67px;
        width: 620px;
    }
    .main02-foot-l{
        border: 1px solid rgb(10, 10, 10);
        float: left;
        margin-left: 10px;
        margin-top: 10px;
        height: 25px;
        width: 90px;
        text-align: center;
    }
    .main02-foot-m{
        border: 1px solid rgb(10, 10, 10);
        float: left;
        margin-left: 200px;
        margin-top: 10px;
        height: 25px;
        width: 90px;
        text-align: center;
    }
    .main02-foot-r{
        border: 1px solid rgb(10, 10, 10);
        float: left;
        margin-left: 250px;
        margin-top: 10px;
        height: 25px;
        width: 90px;
        text-align: center;
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

<div class="main01">
    图片
    <img src="" alt="">
</div>

<div class="main02">
    <div class="main02-header">
        <div class="main02-header-01">
            <div class="main02-header-01-l">头像</div>
            <div class="main02-header-01-r">用户名</div>
        </div>
    </div>
    <div class="main02-header-02">
        <div class="main02-header-02-l">
            文章图片
        </div>
        <div class="main02-header-02-r1">
            <strong>文章标题</strong>
        </div>
        <div class="main02-header-02-r2">
            文章内容
        </div>
    </div>
    <div class="main02-foot-l">
        几条评论
    </div>
    <div class="main02-foot-m">
        ★数量
    </div>
    <div class="main02-foot-r">
        ❤点赞数
    </div>
</div>

</body>
</html>