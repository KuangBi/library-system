<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
    <!--confirm弹出提示框，选择是/否返回true/false,通过if语句执行里面的代码
    使用window.οnlοad=function(){}，要求这段脚本必须在所有的网页东西读完才能运行
     -->
    <script>
        function delUser(id){
            if(confirm("您确定要删除吗")){
                location.href="${pageContext.request.contextPath}/book?method=delBook&id="+id;
            }

        }
       window.onload=function (){
           document.getElementById("select").onclick=function (){
               //表单提交
               if(confirm("您确定要删除吗")){
                   var ids=document.getElementsByClassName("uid");
                   for (var i=0;i<ids.length;i++){
                       //设置ids[i]的checked状态=firstCb.checked
                       if(ids[i].checked){
                           document.getElementById("form").submit();
                           break;
                       }
                   }

               }


           }

           document.getElementById("firstCb").onclick=function (){
               //得到一个数组
               var ids=document.getElementsByName("uid");
               for (var i=0;i<ids.length;i++){
                   //设置ids[i]的checked状态=firstCb.checked
                   ids[i].checked=this.checked;
               }
           }

       }
    </script>
</head>
<body>
<div class="container" >
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <!-- 定义汉堡按钮 -->
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">图书管理系统</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">


                </ul>
                <ul class="nav navbar-nav navbar-right">

                    <li><a href="#">${userName}张三</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">其他<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">管理书架号</a></li>
                            <li><a href="#">管理借阅信息</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#">修改密码</a></li>
                        </ul>
                    </li>
                </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
    <div style="margin: 50px 50px 50px 50px">

    </div>
    <!-- 分隔线，以上是导航条      -->
    <div style="float: left;margin: 10px; ">
        <!-- form提交数据为空，情况两种，一种没设置action，一种没设置name属性-->
        <form class="form-inline" action="${pageContext.request.contextPath}/book?method=getBookList" method="post">
            <div class="form-group">
                <label for="exampleInputName2">图书名称</label>
                <input type="text" name="book_name" value="${condition.book_name[0]}" class="form-control" id="exampleInputName2" >
            </div>
            <div class="form-group">
                <label for="exampleInputName3">书架</label>
                <input type="text" name="build_id" value="${condition.build_id[0]}" class="form-control" id="exampleInputName3" >
            </div>
            <div class="form-group">
                <%--
                <input type="text" name="type_id"  value="${condition.type_name[0]}"class="form-control" id="exampleInputEmail2" >--%>

                <label for="exampleInputEmail2">类型</label>
                <select name="type" id="exampleInputEmail2">

                    <option value="1" >神话</option>
                    <option value="2" >经济</option>
                    <option value="3" >计算机技术</option>
                    <option value="4" >人物</option>

                </select>
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>
    <div style="float: right;margin: 10px; padding: 5px">
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/add.jsp" style="margin: 5px">添加图书</a>
        <a class="btn btn-primary" id="select" href="javascript:void(0);">删除选中</a>
    </div>
    <!-- from表单可以提交多次复选框-->
    <form id="form" action="${pageContext.request.contextPath}/delSelectServlet">
    <table border="1" class="table table-bordered table-hover">
        <tr class="success">

            <th>编号</th>
            <th>书名</th>
            <th>作者</th>
            <th>书架</th>
            <th>类型</th>
            <th>概要</th>
            <th>操作</th>
        </tr>

        <c:forEach items="${pb.list}" var="book" varStatus="s">
            <tr>


                <td>${book.id}</td>
                <td>${book.bookName}</td>
                <td>${book.author}</td>
                <td>${book.buildName}</td>
                <td>${book.typeName}</td>
                <td>${book.introduce}</td>

                <td><a class="btn btn-default btn-sm" href="#">修改</a>&nbsp;
                    <!--写delete是JavaScript内置方法，换个方法名 -->
                    <a class="btn btn-default btn-sm" href="javascript:delUser(${book.id});">删除</a></td></td>
            </tr>

        </c:forEach>



    </table>
    </form>
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <c:if test="${pb.currentPage == 1}">
            <li class="disabled">

                </c:if>

                <c:if test="${pb.currentPage != 1}">
            <li>
                </c:if>
                <a href="${pageContext.request.contextPath}/book?method=getBookList&currentPage=${pb.currentPage-1}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>

            <c:forEach begin="1" end="${pb.totalPage}" var="i">
                <c:if test="${pb.currentPage==i}">
                    <li><a class="active" href="${pageContext.request.contextPath}/book?method=getBookList&currentPage=${i}&rows=5&book_name=${condition.book_name[0]}&build_id=${condition.build_id[0]}&type=${condition.type[0]}">${i}</a></li>
                </c:if>
                <c:if test="${pb.currentPage!=i}">
                    <li><a  href="${pageContext.request.contextPath}/book?method=getBookList&currentPage=${i}&rows=5&book_name=${condition.book_name[0]}&build_id=${condition.build_id[0]}&type=${condition.type[0]}">${i}</a></li>
                </c:if>
            </c:forEach>
            <c:if test="${pb.currentPage == pb.totalPage}">
            <li class="disabled">
                </c:if>

                <c:if test="${pb.currentPage !=pb.totalPage}">
            <li>
                </c:if>
                <a href="${pageContext.request.contextPath}/book?method=getBookList&currentPage=${pb.currentPage+1}&rows=5&book_name=${condition.book_name[0]}&build_id=${condition.build_id[0]}&type=${condition.type[0]}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
            <span style="font-size: 25px;margin-left: 5px">
                共${pb.totalCount}条记录，共${pb.totalPage}页
            </span>
        </ul>
    </nav>
</div>
</body>
</html>
