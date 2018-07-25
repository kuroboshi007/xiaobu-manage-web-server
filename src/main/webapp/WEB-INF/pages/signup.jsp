<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="../../commons/lib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="${ctx}/static/plugin/bootstrap-3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="${ctx}/static/plugin/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="${ctx}/static/plugin/AdminLTE-2.4.3/css/AdminLTE.min.css">
    <link href="${ctx}/static/plugin/layer/theme/default/layer.css" rel="stylesheet" type="text/css"/>
    <title>signup</title>
</head>
<body class="hold-transition login-page">
<div class="login-box">
    <!-- <div class="login-logo">
        <a href="https://gitee.com/liuzhenjn/jeeidp"><b>Jee</b>IDP</a>
    </div> -->
    <div class="login-box-body">
        <p class="login-box-msg">账号注册</p>
        <form id="loginForm">
            <div class="form-group has-feedback">
                <input type="text" name="nickname" id="nickname" class="form-control" placeholder="请输入用户名"  >
                <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="password" name="password" id="password" class="form-control" placeholder="请输入密码" >
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="text" name="phone" id="phone" class="form-control" placeholder="请输入手机号" >
                <span class="glyphicon glyphicon-earphone form-control-feedback"></span>
            </div>
            <div class="input-group">
                <input type="text" name="vCode" id="vCode" class="form-control" placeholder="请输入验证码" >
                <span class="input-group-addon btn btn-default" id="getSms">点击获取验证码</span>
            </div>
            <div class="row">
                <div class="col-md-5 pull-right">
                    <button type="button" onclick="signup()" class="btn btn-primary btn-block btn-flat">注册</button>
                </div>
            </div>
        </form>
    </div>
</div>

</body>
<script type="text/javascript" src="${ctx}/static/plugin/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${ctx}/static/plugin/bootstrap-3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${ctx}/static/plugin/layer/layer.js"></script>
<script type="text/javascript">
     function signup(){

         if($("#nickname").val()==""){
             layer.alert("请填写用户名")
         }else if($("#password").val()==""){
             layer.alert("请输入密码");
         }else if($("#phone").val()==""){
             layer.alert("请输入电话号码");
         }else{
             $.ajax({
                 type: 'post',
                 url: '/signup/signup',
                 data: $('#loginForm').serialize(),
                 dataType: 'json',
                 success: function(data){
                     console.log(data);
                     layer.alert(data.result[0]);
                 }
             });
         }
     }

    $("#getSms").click(function () {
         $.ajax({
            type: 'post',
            url: '/baseinterface/obtainSms',
            data: {'number':$("#phone").val()},
            dataType: 'json',
            success: function(data){
            	if(data.code == 200){
            		layer.alert("验证码已发送");
            	}else{
            		layer.alert("获取验证码错误");
            	}
            }
        }); 
    })
</script>
</html>