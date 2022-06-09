<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>添加图书页</title>
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
    <li><a href="${pageContext.request.contextPath}/book?method=getBookList">管理员主页</a></li>
    <li class="active">修改图书页</li>
</ul>
<div class="container" style="width: 400px;">

    <form action="${pageContext.request.contextPath}/book?method=updateBook" method="post">
        <div class="form-group">
            <label for="id">书id</label>
            <input type="text" name="id" value="${book.id}" class="form-control" id="id" placeholder="请输入唯一id"/>
        </div>



        <div class="form-group">
            <label for="bookName">书名</label>
            <input type="text" name="bookName" value="${book.bookName}" class="form-control" id="bookName" placeholder="请输入密码"/>
        </div>
        <div class="form-group">
            <label for="author">作者</label>
            <input type="text" name="author" value="${book.author}"class="form-control" id="author" placeholder="请输入密码"/>
        </div>
        <div class="form-group">
            <label for="buildId">书架id</label>
            <input type="text" name="buildId"value="${book.buildId}" class="form-control" id="buildId" placeholder="请输入密码"/>
        </div>
        <div class="form-group">
            <label for="type">类型</label>
            <input type="text" name="type" value="${book.type}" class="form-control" id="type" placeholder="请输入密码"/>
        </div>
        <div class="form-group">
            <label for="introduce">介绍</label>
            <input type="text" name="introduce" value="${book.introduce}"class="form-control" id="introduce" placeholder="请输入密码"/>
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
