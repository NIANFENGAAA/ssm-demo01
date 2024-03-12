<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 朱文强
  Date: 2024/2/27
  Time: 8:33
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>矩阵加法运算</title>
</head>

<style>
    @import url("//unpkg.com/element-ui@2.15.14/lib/theme-chalk/index.css");
    .el-col {
        border-radius: 4px;
    }
    .bg-purple-dark {
        background: #99a9bf;
    }
    .bg-purple {
        background: #d3dce6;
    }
    .bg-purple-light {
        background: #e5e9f2;
    }
    .grid-content {
        border-radius: 4px;
        min-height: 400px;
    }

    .myInput{
        width: 500px;
        height: 300px;
        position: absolute;

    }
    .submit{
        width: 100px;
        height: 100px;
        position: absolute;
    }

</style>

<body>

<script src="//unpkg.com/vue@2/dist/vue.js"></script>
<script src="//unpkg.com/element-ui@2.15.14/lib/index.js"></script>


<el-page-header @back="goBack" content="详情页面">
</el-page-header>

<div id="app">
    <form name="test" method="post" action="${pageContext.request.contextPath}/matrixAddition" id="test" >
    <el-row :gutter="10">

        <el-col :xs="8" :sm="6" :md="4" :lg="3" :xl="1"><div class="grid-content bg-purple">
            <div>
                <h4>请输入行数:</h4>
                <input name="row1" id="row1" class="text">
                <h4>请输入列数:</h4>
                <input name="colum1" id="colum1" class="text">
            </div>
        </div></el-col>

        <el-col :xs="4" :sm="6" :md="8" :lg="9" :xl="11"><div class="grid-content bg-purple-light">
            <h4>请输入矩阵，注意以“,”分隔</h4>
            <input height="200px" width="200px" name="body1" id="body1" class="myInput">
        </div></el-col>

        <el-col :xs="8" :sm="6" :md="4" :lg="3" :xl="1"><div class="grid-content bg-purple">
            <div>
                <h4>请输入行数:</h4>
                <input name="row2" id="row2" class="text">
                <h4>请输入列数:</h4>
                <input name="colum2" id="colum2" class="text">
            </div>
        </div></el-col>

        <el-col :xs="4" :sm="6" :md="8" :lg="9" :xl="11"><div class="grid-content bg-purple-light">
            <h4>请输入矩阵，注意以“,”分隔</h4>
            <input height="200px" width="200px" name="body2" id="body2" class="myInput">
        </div></el-col>

    </el-row>

        <input type="submit" class="button" value="提交">

    </form>



    <h3>结果如下:</h3>

    <el-col :xs="4" :sm="6" :md="8" :lg="9" :xl="11"><div class="grid-content bg-purple-light">

        <c:forEach items="${sessionScope.list}" var="row">
            <h4>${row}</h4>
        </c:forEach>

    </div></el-col>



</div>




</body>


<script>
    export default {
        methods: {
            goBack() {
                console.log('go back');
            }
        }
    }
</script>


<script>
    new Vue().$mount('#app')
</script>
<%--<script>--%>
<%--    function check(value) {--%>
<%--        if (value==='test1'){--%>
<%--            document.getElementById("test1").action="${pageContext.request.contextPath}/matrixAddition";--%>
<%--        } else if (value==='test2'){--%>
<%--            document.getElementById("test2").action="${pageContext.request.contextPath}/matrixAddition";--%>
<%--        }--%>

<%--    }--%>
<%--</script>--%>
</html>
