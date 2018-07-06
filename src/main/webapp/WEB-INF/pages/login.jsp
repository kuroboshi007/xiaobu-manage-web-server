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
<title>login</title>
</head>
<body class="hold-transition login-page">
    <div class="login-box">
		<!-- <div class="login-logo">
			<a href="https://gitee.com/liuzhenjn/jeeidp"><b>Jee</b>IDP</a>
		</div> -->
		<div class="login-box-body">
	    	<p class="login-box-msg">Sign in to start your session</p>
	    	<form id="loginForm">
	      		<div class="form-group has-feedback">
	        		<input type="text" name="username" class="form-control" placeholder="用户名" value="admin">
	        		<span class="glyphicon glyphicon-envelope form-control-feedback"></span>
	      		</div>
	      		<div class="form-group has-feedback">
	        		<input type="password" name="password" class="form-control" placeholder="密码" value="123456">
	        		<span class="glyphicon glyphicon-lock form-control-feedback"></span>
	      		</div>
	      		<div class="row">
	        		<div class="col-md-5 pull-right">
	          			<button type="button" onclick="login()" class="btn btn-primary btn-block btn-flat">登录</button>
	        		</div>
	      		</div>
	    	</form>
	  	</div>
	</div>
			<!-- <form id="loginForm">
			   <div>
			        <input name="username" type="text"/>
			   </div>
			   <div>
			        <input name="password" type="password"/> 
			   </div>
			   <div>
			         <button type="button" onclick="login()" class="btn btn-primary btn-block btn-flat">登录</button>
			   </div>
			</form> -->
</body>
<script type="text/javascript" src="${ctx}/static/plugin/bootstrap-3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
function login(){
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
</script>
</html>