<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>用户注册</title>
    <script src="js/vue.js"></script>
    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>

</head>
<body>
<div class="container" style="width: 400px;" id="app">
    <h3 style="text-align: center;">欢迎用户注册</h3>


        <form action="${pageContext.request.contextPath}/user?method=doRegist" method="post">
            <div class="form-group">
                <label for="uId">用户号：</label>
                <input type="text" name="uId" class="form-control" id="uId" placeholder="请输入唯一id | 推荐手机号注册"/>
            </div>

            <div class="form-group">
                <label for="userName">用户名：</label>
                <input type="text" name="userName" class="form-control" id="userName" placeholder="请输入用户名" v-model="username" @blur="registerCheck"/>
                <span style="color: red">{{usernameErrorMessage}}</span>
            </div>

            <div class="form-group">
                <label for="password">密码：</label>
                <input type="password" name="password" class="form-control" id="password" placeholder="请输入密码" v-model="password" @blur="registerCheck"/>
                <span style="color: red">{{passwordErrorMessage}}</span>
            </div>
            <div class="form-group">
            <label>确认密码:</label>
            <input type="password" placeholder="请输入确认密码" class="form-control" v-model="passwordConfirm" @blur="registerCheck"/>
            <span style="color: red">{{confirmErrorMessage}}</span>
            </div>
            <div class="form-group">

                    <label>用户邮箱:</label>
                    <input type="text" placeholder="请输入邮箱" class="form-control" name="email" v-model="email" @blur="registerCheck"/>
                    <span style="color: red">{{emailErrorMessage}}</span>
            </div>
            <div class="form-group">
                <label>用户电话:</label>
                <input type="phone" placeholder="请输入电话" class="form-control" v-model="phone" @blur="registerCheck"/>
                <span style="color: red">{{phoneErrorMessage}}</span>
            </div>
            <div class="form-group">

                <input type="hidden"  class="form-control" name="state" value="1"/>

            </div>
            <hr/>
            <div class="form-group" style="text-align: center;">
                <input class="btn btn btn-primary" type="submit" value="注册">
            </div>
        </form>






</div>
<script>
    var vue = new Vue({
        "el":"#app",
        "data":{
            "username":"",//用户名
            "password":"",//密码
            "passwordConfirm":"",//确认密码
            "email":"",//邮箱
            "code":"",//验证码
            "phone":"",//电话号
            "usernameErrorMessage":"",
            "passwordErrorMessage":"",
            "confirmErrorMessage":"",
            "emailErrorMessage":"",
            "phoneErrorMessage":""
        },
        "methods":{
            checkUsername(){
                //校验用户名是否符合规则
                //1. 编写一个正则表达式去描述这个规则
                var usernameRegExp = /^[A-Za-z0-9_]{5,8}$/;
                //2. 使用正则表达式校验用户名输入框里面的内容:this.username
                if (!usernameRegExp.test(this.username)) {
                    //校验不通过
                    this.usernameErrorMessage = "用户名必须是5-8位的数字、字母或者下划线"
                }else {
                    //符合规则了,就重新设置提示信息为空
                    this.usernameErrorMessage = ""
                }
            },
            registerCheck(){
                //注册校验的方法
                //1. 校验用户名
                //1.1 编写一个正则表达式去描述这个规则
                var usernameRegExp = /^[A-Za-z0-9_]{5,8}$/;
                //1.2 校验用户名是否符合规则
                if (!usernameRegExp.test(this.username)) {
                    //用户名不符合规则，那么就阻止默认事件
                    event.preventDefault()

                    this.usernameErrorMessage = "用户名必须是5-8位的数字、字母或者下划线"
                    return;
                }else {
                    this.usernameErrorMessage =""
                }
                //2. 校验密码
                //2.1 编写一个正则表达式去描述密码校验的规则
                var passwordRegExp = /^[A-Za-z0-9_]{6,10}$/;
                //2.2 使用正则表达式校验密码
                if (!passwordRegExp.test(this.password)) {
                    //密码不符合规则，那么就阻止默认事件
                    event.preventDefault()

                    this.passwordErrorMessage = "密码必须是6-10位的数字、字母或者下划线"
                    return
                }else {
                    this.passwordErrorMessage = ""
                }
                //3. 校验确认密码
                //3.1 就是对比确认密码输入框的内容和密码输入框的内容是否一样
                if (this.password != this.passwordConfirm) {
                    event.preventDefault()
                    this.confirmErrorMessage = "两次输入的密码必须一致"
                    return
                }else {
                    this.confirmErrorMessage = ""
                }
                //4. 校验邮箱格式
                var emailRegExp = /^[a-zA-Z0-9_\.-]+@([a-zA-Z0-9-]+[\.]{1})+[a-zA-Z]+$/;
                if(!emailRegExp.test(this.email)){
                    event.preventDefault()

                    this.emailErrorMessage = "邮箱格式不正确"
                    return
                }else {
                    this.emailErrorMessage = ""
                }
                //5.校验电话格式
                var phoneRegExp=/^1[0-9]{10}$/;
                if(!phoneRegExp.test(this.phone)){
                    event.preventDefault()

                    this.phoneErrorMessage = "电话格式不正确"
                    return
                }else {
                    this.phoneErrorMessage = ""
                }
            }
        }

    });

</script>
</body>
</html>


