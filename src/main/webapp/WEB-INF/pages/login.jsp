<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../../commons/lib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
	<link rel="stylesheet" href="${ctx}/statics/plugin/bootstrap-3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="${ctx}/statics/plugin/font-awesome-4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="${ctx}/statics/plugin/AdminLTE-2.4.3/css/AdminLTE.min.css">
	<link href="${ctx}/statics/plugin/layer/theme/default/layer.css" rel="stylesheet" type="text/css"/>
<title>login</title>
</head>
<body class="hold-transition login-page">
    <div class="login-box">
		<!-- <div class="login-logo">
			<a href="https://gitee.com/liuzhenjn/jeexiaobu"><b>Jee</b>xiaobu</a>
		</div> -->
		<div class="login-box-body">
	    	<p class="login-box-msg">Small Data</p>
	    	<form id="loginForm">
	      		<div class="form-group has-feedback">
	        		<input type="text" name="username" id="username" class="form-control" placeholder="用户名" value="admin">
	        		<span class="glyphicon glyphicon-envelope form-control-feedback"></span>
	      		</div>
	      		<div class="form-group has-feedback">
	        		<input type="password" name="password" id="password" class="form-control" placeholder="密码" value="123456">
	        		<span class="glyphicon glyphicon-lock form-control-feedback"></span>
	      		</div>
	      		<div class="row">
	        		<div class="col-md-5 pull-right">
	          			<button type="button" onclick="login()" class="btn btn-primary btn-block btn-flat">登录</button>
	        		</div>
					<div class="col-md-5 pull-left">
						<button type="button" onclick="signup()" class="btn btn-primary btn-block btn-flat">注册</button>
					</div>
	      		</div>
	    	</form>
	  	</div>
	</div>
</body>
<script type="text/javascript" src="${ctx}/statics/plugin/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${ctx}/statics/plugin/bootstrap-3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${ctx}/statics/plugin/layer/layer.js"></script>
<script type="text/javascript">
function login(){
    if($("#username").val()==""){
        layer.alert("请输入用户名")
	}else if($("#password").val()==""){
        layer.alert("请输入密码")
	}else{
        $.ajax({
            type: 'post',
            url: '/login/checklogin',
            data: $('#loginForm').serialize(),
            dataType: 'json',
            success: function(data){
                console.log(data);
                if(data.code==200){
                    window.location.href = '/index';
                }else{
                    layer.alert(data.result);
                }
            }
        });
	}
}

function signup() {
    window.location.href = '/signup/init';
}
</script>
</html>