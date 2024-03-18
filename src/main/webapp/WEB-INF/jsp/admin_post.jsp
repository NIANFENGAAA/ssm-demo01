<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 朱文强
  Date: 2024/2/26
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">

    <title>主页</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link href="css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.css?v=4.3.0" rel="stylesheet">

    <!-- Morris -->
    <link href="css/plugins/morris/morris-0.4.3.min.css" rel="stylesheet">

    <!-- Gritter -->
    <link href="js/plugins/gritter/jquery.gritter.css" rel="stylesheet">

    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=2.2.0" rel="stylesheet">

    <style>
        .main{
            border: 1px solid black;
            /*margin: 0;*/
            margin-left: 50px;
            margin-top: 50px;
            /*background-color: lightblue;*/
            height: 1000px;
            width: 90%;
            /*top: 100px;*/
            /*left: 50px;*/
            float: left;
        }
        .main_header{
            border: 1px solid black;
            margin-top: 10px;
            margin-left: 100px;
            height: 100px;
            width: 1100px;
            float: left;
        }
        /* .main_header_l{
            border: 1px solid black;
            margin-top: 10px;
            margin-left: 10px;
            height: 80px;
            width: 350px;
            float: left;
        } */
        .main_header_l_sousuo{
            border: 1px solid black;
            margin-top: 20px;
            margin-left: 330px;
            float: left;
        }
        /*.main_header_r{*/
        /*    border: 1px solid black;*/
        /*    margin-top: 10px;*/
        /*    margin-right: 10px;*/
        /*    height: 80px;*/
        /*    width: 650px;*/
        /*    float: right;*/
        /*}*/
        .main_header_r_1{
            border: 1px solid black;
            margin-top: 20px;
            margin-left: 2px;
            float: left;
        }
        .main_header_r_2{
            border: 1px solid black;
            margin-top: 20px;
            margin-left: 20px;
            float: left;
        }
        .main_header_r_3{
            border: 1px solid black;
            margin-top: 20px;
            margin-right: 60px;
            float: right;
        }
        .main_01{
            border: 1px solid black;
            margin-top: 25px;
            margin-left: 100px;
            height: 800px;
            width: 1100px;
            float: left;
        }



    </style>


</head>

<body>
<div id="wrapper">
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav" id="side-menu">
                <li class="nav-header">

                    <div class="dropdown profile-element"> <span>
                            <img alt="image" class="img-circle" src="profile_small.jpg" />
                             </span>
                        <a data-toggle="dropdown" class="dropdown-toggle" href="index.html#">
                                <span class="clear"> <span class="block m-t-xs"> <strong class="font-bold">${sessionScope.username}</strong>
                             </span> <span class="text-muted text-xs block">管理员<b class="caret"></b></span> </span>
                        </a>
                        <ul class="dropdown-menu animated fadeInRight m-t-xs">
                            <li><a href="${pageContext.request.contextPath}/goUpdatePassword">修改密码</a>
                            </li>
                            <li><a href="${pageContext.request.contextPath}/goUpdateUser">修改资料</a>
                            </li>
                            <li><a href="contacts.html">联系我们</a>
                            </li>
                            <li><a href="mailbox.html">信箱</a>
                            </li>
                            <li class="divider"></li>
                            <li><a href="${pageContext.request.contextPath}/exitUser">安全退出</a>
                            </li>
                        </ul>
                    </div>
                    <div class="logo-element">
                        H+
                    </div>

                </li>

                <li>
                    <a href="http://localhost:8080/Project06_war//adminGetAllUser?keyword="><i class="fa fa-edit"></i> <span class="nav-label">用户管理</span><span class="fa arrow"></span></a>
                </li>

                <li>
                    <a href="http://localhost:8080/Project06_war//adminGetAllAlgorithm?keyword="><i class="fa fa-edit"></i> <span class="nav-label">算法管理</span><span class="fa arrow"></span></a>

                </li>
                <li>
                    <a href="http://localhost:8080/Project06_war//adminGetAllPost?keyword="><i class="fa fa-edit"></i> <span class="nav-label">帖子管理</span><span class="fa arrow"></span></a>

                </li>
                <li>
                    <a href="${pageContext.request.contextPath}"><i class="fa fa-edit"></i> <span class="nav-label">日志管理</span><span class="fa arrow"></span></a>

                </li>
            </ul>
        </div>
    </nav>







    <div id="page-wrapper" class="gray-bg dashbard-1">
        <div class="row border-bottom">
            <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header">
                    <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="index.html#"><i class="fa fa-bars"></i> </a>
                    <form role="search" class="navbar-form-custom" method="post" action="search_results.html">
                        <div class="form-group">
                            <input type="text" placeholder="请输入您需要查找的内容 …" class="form-control" name="top-search" id="top-search">
                        </div>
                    </form>
                </div>
                <ul class="nav navbar-top-links navbar-right">
                    <li>
                        <span class="m-r-sm text-muted welcome-message"><a href="index.html" title="返回首页"><i class="fa fa-home"></i></a>欢迎使用</span>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle count-info" data-toggle="dropdown" href="index.html#">
                            <i class="fa fa-envelope"></i> <span class="label label-warning"></span>
                        </a>
                        <ul class="dropdown-menu dropdown-messages">
                            <li>
                                <div class="dropdown-messages-box">
                                    <a href="profile.html" class="pull-left">
                                        <img alt="image" class="img-circle" src="img/a7.jpg">
                                    </a>
                                    <div class="media-body">
                                        <small class="pull-right">46小时前</small>
                                        <strong>小四</strong> 项目已处理完结
                                        <br>
                                        <small class="text-muted">3天前 2014.11.8</small>
                                    </div>
                                </div>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <div class="dropdown-messages-box">
                                    <a href="profile.html" class="pull-left">
                                        <img alt="image" class="img-circle" src="img/a4.jpg">
                                    </a>
                                    <div class="media-body ">
                                        <small class="pull-right text-navy">25小时前</small>
                                        <strong>国民岳父</strong> 这是一条测试信息
                                        <br>
                                        <small class="text-muted">昨天</small>
                                    </div>
                                </div>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <div class="text-center link-block">
                                    <a href="mailbox.html">
                                        <i class="fa fa-envelope"></i> <strong> 查看所有消息</strong>
                                    </a>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle count-info" data-toggle="dropdown" href="index.html#">
                            <i class="fa fa-bell"></i> <span class="label label-primary">8</span>
                        </a>
                        <ul class="dropdown-menu dropdown-alerts">
                            <li>
                                <a href="mailbox.html">
                                    <div>
                                        <i class="fa fa-envelope fa-fw"></i> 您有16条未读消息
                                        <span class="pull-right text-muted small">4分钟前</span>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="profile.html">
                                    <div>
                                        <i class="fa fa-qq fa-fw"></i> 3条新回复
                                        <span class="pull-right text-muted small">12分钟钱</span>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <div class="text-center link-block">
                                    <a href="notifications.html">
                                        <strong>查看所有 </strong>
                                        <i class="fa fa-angle-right"></i>
                                    </a>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/exitUser">
                            <i class="fa fa-sign-out"></i> 退出
                        </a>
                    </li>
                </ul>

            </nav>
        </div>

        <%--主体内容--%>
        <div class="main">
            <div class="main_header">
                <div class="main_header_l">
                    <div class="main_header_l_sousuo">
                        <form method="get" action="${pageContext.request.contextPath}/adminGetAllPost">
                            <input name="keyword" value="">
                            <button type="submit">搜索</button>
                        </form>
                    </div>
                </div>
            </div>

            <div class="main_01">
                <table width="1041" height="139.333" border="1" style="table-layout: fixed">
                    <tbody>
                    <tr>
                        <th scope="col" width="20%"><div align="center">帖子编号</div></th>
                        <th scope="col" width="50%"><div align="center">帖子名称</div></th>
                        <%--                            <th scope="col" width="50%"><div align="center">存放路径</div></th>--%>
                        <%--                        <th scope="col" width="30%"><div align="center">状态</div></th>--%>
                        <th scope="col" width="30%"><div align="center">操作</div></th>
                    </tr>
                    <c:forEach items="${sessionScope.posts_admin}" var="post">
                        <tr>
                            <td width="20%"><div align="center">${post.id}</div></td>
                            <td width="50%"><div align="center">${post.post_name}</div></td>
                                <%--                            <td width="30%"><div align="center">--%>
                                <%--                                <c:if test="${user.status == 0}"><h4>可用</h4></c:if>--%>
                                <%--                                <c:if test="${user.status == 1}"><h4>禁用</h4></c:if>--%>
                                <%--                            </div></td>--%>
                            <td width="30%"><div align="center">
                                    <%--                                    <a href="http://localhost:8080/Project06_war//"><h4>编辑</h4></a>--%>
                                    <%--                                <a href="http://localhost:8080/Project06_war//user/prohibitUser?userId=${user.id}"><h4>禁用</h4></a>--%>
                                <a href="http://localhost:8080/Project06_war//deletePostById?id=${post.id}"><h4>删除</h4></a>
                            </div></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

                <div class="fenye">
                    <table width="700" height="71" border="0" align="center">
                        <tr>
                            <td width="150" height="65">总共：${postByPageAdmin.total}条数据</td>
                            <td width="200">当前：第${postByPageAdmin.pageNum}/${postByPageAdmin.pages}页</td>
                            <td width="350">请选择：第
                                <c:forEach var="num" begin="1" end="${postByPageAdmin.pages}">
                                    <a href="http://localhost:8080/Project06_war//adminPostPageInfo?pageNum=${num}">${num}</a>
                                </c:forEach>
                                页</td>

                        </tr>
                    </table>

                </div>

            </div>

        </div>



        <div class="row  border-bottom white-bg dashboard-header">
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="wrapper wrapper-content">
                    <div class="row">

                    </div>
                </div>

            </div>
            <div class="footer">
                <div class="pull-right">
                    By：<a href="http://www.zi-han.net" target="_blank">zihan's blog</a>
                </div>
                <div>
                    <strong>Copyright</strong> H+ &copy; 2014
                </div>
            </div>
        </div>

    </div>
</div>

<!-- Mainly scripts -->
<script src="js/jquery-2.1.1.min.js"></script>
<script src="js/bootstrap.min.js?v=3.4.0"></script>
<script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

<!-- Custom and plugin javascript -->
<script src="js/hplus.js?v=2.2.0"></script>
<script src="js/plugins/pace/pace.min.js"></script>

<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
<!--统计代码，可删除-->
<div class="theme-config">
    <div class="theme-config-box show">
        <div class="spin-icon">
            <i class="fa fa-cog fa-spin"></i>
        </div>









    </div>
</div><script>
    // 顶部菜单固定
    $('#fixednavbar').click(function () {
        if ($('#fixednavbar').is(':checked')) {
            $(".navbar-static-top").removeClass('navbar-static-top').addClass('navbar-fixed-top');
            $("body").removeClass('boxed-layout');
            $("body").addClass('fixed-nav');
            $('#boxedlayout').prop('checked', false);
        } else {
            $(".navbar-fixed-top").removeClass('navbar-fixed-top').addClass('navbar-static-top');
            $("body").removeClass('fixed-nav');
        }
    });

    // 左侧菜单固定
    $('#fixedsidebar').click(function () {
        if ($('#fixedsidebar').is(':checked')) {
            $("body").addClass('fixed-sidebar');
            $('.sidebar-collapse').slimScroll({
                height: '100%',
                railOpacity: 0.9
            });
        } else {
            $('.sidebar-collapse').slimscroll({
                destroy: true
            });
            $('.sidebar-collapse').attr('style', '');
            $("body").removeClass('fixed-sidebar');
        }
    });

    // 收起左侧菜单
    $('#collapsemenu').click(function () {
        if ($('#collapsemenu').is(':checked')) {
            $("body").addClass('mini-navbar');
            SmoothlyMenu();
        } else {
            $("body").removeClass('mini-navbar');
            SmoothlyMenu();
        }
    });

    // 自适应宽度
    $('#boxedlayout').click(function () {
        if ($('#boxedlayout').is(':checked')) {
            $("body").addClass('boxed-layout');
            $('#fixednavbar').prop('checked', false);
            $(".navbar-fixed-top").removeClass('navbar-fixed-top').addClass('navbar-static-top');
            $("body").removeClass('fixed-nav');
            $(".footer").removeClass('fixed');
            $('#fixedfooter').prop('checked', false);
        } else {
            $("body").removeClass('boxed-layout');
        }
    });

    // 底部版权固定
    $('#fixedfooter').click(function () {
        if ($('#fixedfooter').is(':checked')) {
            $('#boxedlayout').prop('checked', false);
            $("body").removeClass('boxed-layout');
            $(".footer").addClass('fixed');
        } else {
            $(".footer").removeClass('fixed');
        }
    });

    // RTL模式
    $('#RTLmode').click(function () {
        if ($('#RTLmode').is(':checked')) {
            $('head').append('<link href="css/bootstrap-rtl.css" id="rtl-mode" rel="stylesheet">');
            $('body').addClass('rtls');
        } else {
            $('#rtl-mode').remove();
            $('body').removeClass('rtls');
        }
    });

    // 皮肤选择
    $('.spin-icon').click(function () {
        $(".theme-config-box").toggleClass("show");
    });

    // 默认主题
    $('.s-skin-0').click(function () {
        $("body").removeClass("skin-1");
        $("body").removeClass("skin-2");
        $("body").removeClass("skin-3");
    });

    // 蓝色主题
    $('.s-skin-1').click(function () {
        $("body").removeClass("skin-2");
        $("body").removeClass("skin-3");
        $("body").addClass("skin-1");
    });

    // 灰色主题
    $('.s-skin-2').click(function () {
        $("body").removeClass("skin-1");
        $("body").removeClass("skin-3");
        $("body").addClass("skin-2");
    });

    // 黄色主题
    $('.s-skin-3').click(function () {
        $("body").removeClass("skin-1");
        $("body").removeClass("skin-2");
        $("body").addClass("skin-3");
    });
</script><style>
    .fixed-nav .slimScrollDiv #side-menu {
        padding-bottom: 60px;
    }
</style>
</body>

</html>