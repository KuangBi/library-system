<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>管理员登录</title>
    <script src="js/vue.js"></script>
    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
        function refreshCode(){
           var vcode= document.getElementById("vcode");
           vcode.src="${pageContext.request.contextPath}/checkCodeServlet?time="+new Date().getTime();
        }
    </script>
</head>
<body>
<div class="container" style="width: 400px;" id="app">
    <h3 style="text-align: center;">图书管理系统</h3>

    <div  v-if="skip">
        <form action="${pageContext.request.contextPath}/user?method=doLogin" method="post">
            <div class="form-group">
                <label for="uId">用户号：</label>
                <input type="text" name="uId" class="form-control" id="uId" placeholder="请输入唯一id"/>
            </div>

            <div class="form-group">
                <label for="userName">用户名：</label>
                <input type="text" name="userName" class="form-control" id="userName" placeholder="请输入用户名"/>
            </div>

            <div class="form-group">
                <label for="password">密码：</label>
                <input type="password" name="password" class="form-control" id="password" placeholder="请输入密码"/>
            </div>


            <div class="form-inline">
                <label for="vcode">验证码：</label>
                <input type="text" name="verifycode" class="form-control" id="verifycode" placeholder="请输入验证码" style="width: 120px;"/>
                <a href="javascript:refreshCode()"><img src="${pageContext.request.contextPath}/checkCodeServlet" title="看不清点击刷新" id="vcode"/></a>
            </div>
            <hr/>
            <div class="form-group" style="text-align: center;">
                <input class="btn btn btn-primary" type="submit" value="登录">
            </div>
        </form>
        <!-- 出错显示的信息框 -->
        <div class="alert alert-warning alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" >
                <span>&times;</span></button>
            <strong>${log_msg}</strong>
        </div>
    </div>



    <div v-if="!skip">
        <form   action="${pageContext.request.contextPath}/user?method=doLogin" method="post">
            <div class="form-group">
                <label for="uId">管理员ID</label>
                <input type="text" name="uId" class="form-control" id="uId" placeholder="请输入管理员ID"/>
            </div>
            <div class="form-group">
                <label for="userName">管理员名：</label>
                <input type="text" name="userName" class="form-control" id="userName" placeholder="请输入管理员名"/>
            </div>

            <div class="form-group">
                <label for="password">密码：</label>
                <input type="password" name="password" class="form-control" id="password" placeholder="请输入密码"/>
            </div>

            <div class="form-inline">
                <label for="vcode">验证码：</label>
                <input type="text" name="verifycode" class="form-control" id="verifycode" placeholder="请输入验证码" style="width: 120px;"/>
                <a href="javascript:refreshCode()"><img src="${pageContext.request.contextPath}/checkCodeServlet" title="看不清点击刷新" id="vcode"/></a>
            </div>
            <hr/>
            <div class="form-group" style="text-align: center;">
                <input class="btn btn btn-primary" type="submit" value="登录">
            </div>
        </form>
        <!-- 出错显示的信息框 -->
        <div class="alert alert-warning alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" >
                <span>&times;</span></button>
            <strong>${log_msg}</strong>
        </div>
    </div>





    <a @click="skipMethod" href="#" style="text-align: left">切换至管理员</a>
</div>
<script>
    var vue=new Vue({
        "el":"#app",
        "data":{
            "skip":true
        },
        "methods":{
            "skipMethod":function (){
               this.skip=false
            }
        }
    })

</script>
</body>
</html>


