<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <script>
        function delUser(id){
            if(confirm("您确定要删除吗")){
                location.href="${pageContext.request.contextPath}/build?method=delBuild&id="+id;
            }

        }
    </script>
</head>

<body>
<ul class="breadcrumb">
    <li><a href="${pageContext.request.contextPath}/login.jsp">图书管理系统</a></li>
    <li><a href="${pageContext.request.contextPath}/book?method=getBookList">管理员主页</a></li>
    <li class="active">书架信息</li>
</ul>
<div class="container" >
    <div style="float: right;margin: 10px; padding: 5px">
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/buildAdd.jsp" style="margin: 5px">添加图书</a>

    </div>

    <form id="form" action="${pageContext.request.contextPath}/delSelectServlet">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">

                <th>书架编号</th>
                <th>书架名</th>

            </tr>

            <c:forEach items="${buildList}" var="build" varStatus="s">
                <tr>


                    <td>${build.id}</td>
                    <td>${build.buildName}</td>


                    <td>
                        <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/build?method=toUpdateBuild&id=${build.id}">修改</a>&nbsp;
                        <!--写delete是JavaScript内置方法，换个方法名 -->
                        <a class="btn btn-default btn-sm" href="javascript:delUser(${build.id});">删除</a>

                    </td>
                 </tr>

            </c:forEach>



            </table>
        </form>
     </div>

    </body>
</html>
