<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html  class="x-admin-sm">
<head>
	<meta charset="UTF-8">
	<title>注册</title>
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="stylesheet" href="./css/font.css">
    <link rel="stylesheet" href="./css/login.css">
	  <link rel="stylesheet" href="./css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="./lib/layui/layui.js" charset="utf-8"></script>
    <!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class="login-bg">
    
    <div class="login layui-anim layui-anim-up">
        <div class="message">注册</div>
        <div id="darkbannerwrap"></div>
        
        <form method="post" class="layui-form" id="registerForm">
            <input name="userName" placeholder="用户名"  type="text" lay-verify="required" class="layui-input" >
            <hr class="hr15">
            <input name="realName" placeholder="真实姓名"  type="text" lay-verify="required" class="layui-input" >
            <hr class="hr15">
            <input id="password" name="password" lay-verify="required" placeholder="密码"  type="password" class="layui-input">
            <hr class="hr15">
            <input name="repass" lay-verify="repass" placeholder="确认密码"  type="password" class="layui-input">
            <hr class="hr15">
            <input value="注册" lay-submit lay-filter="register" style="width:100%;" type="submit">
            <hr class="hr20" >
        </form>
    </div>

    <script>
        $(function() {
            layui.use('form', function(){
              var form = layui.form;
              form.verify({
                  repass: function(value) {
                      if (value.length === 0) {
                          return '确认密码必填项';
                      }
                      if (value !== $("#password").val()) {
                          return "密码确认有误";
                      }
                  }
                });
              //监听提交
              form.on('submit(register)', function(data){
                const registerForm = $('#registerForm').serialize();
                  $.ajax({
                      type:"post",
                      url:"register",
                      data:registerForm,
                      dataType:"text",
                      success: function (result) {
                          if (result === "success") {
                              layer.msg("注册成功！即将跳转登录页", {icon:1,anim:2,time:1000}, function(){
                                  location.href='login'
                              });
                          } else {
                              layer.msg("注册失败", {icon:1,anim:2,time:1000});
                          }
                      }
                  });
                return false;
              });
            });
        })
    </script>
</body>
</html>