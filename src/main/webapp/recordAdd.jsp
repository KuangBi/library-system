<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>添加记录页</title>
    <script src="js/vue.js"></script>
    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>


   <%-- <style type="text/css">
        body{
            background:url("https://images.pexels.com/photos/844297/pexels-photo-844297.jpeg?auto=compress&cs=tinysrgb&h=650&w=940");
            background-repeat: no-repeat;
            background-size: cover;
        }
    </style>--%>
</head>

<body>
<ul class="breadcrumb">
    <li><a href="${pageContext.request.contextPath}/login.jsp">图书管理系统</a></li>
    <li><a href="${pageContext.request.contextPath}/book?method=getBookList">用户主页</a></li>
    <li class="active">添加记录页</li>
</ul>
<div class="container" style="width: 400px;">

        <form action="${pageContext.request.contextPath}/book?method=addBook" method="post">



            <div class="form-group">
                <label for="bookId">书籍编号</label>
                <input type="text" name="bookId" class="form-control" id="bookId" placeholder="请输入作者名"/>
            </div>
            <div class="form-group">
                <label for="uid">用户编号</label>
                <input type="text" name="uid" class="form-control" id="uid" placeholder="请输入书架id"/>
            </div>

            <div class="form-group">
                <label for="createTime">创建时间</label>
                <input type="datetime-local" name="createTime" class="form-control" id="createTime" placeholder="请输入详细简介"/>
            </div>
            <div class="form-group">
                <label for="backTime">归还时间</label>
                <input type="datetime-local" name="backTime" class="form-control" id="backTime" placeholder="请输入详细简介"/>
            </div>
            <div class="form-group">
                <label for="reState">状态</label>
                <input type="hidden" name="reState" value="1" class="form-control" id="reState" />
            </div>
            <hr/>
            <div class="form-group" style="text-align: center;">
                <input class="btn btn btn-primary" type="submit" value="登录">
            </div>
        </form>



</div> <!-- /container -->


<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->

</body>
</html>
