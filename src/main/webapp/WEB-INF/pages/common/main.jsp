<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../../../commons/lib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
	<title>LittleDemo</title>
	<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport"/>
	<link rel="stylesheet" href="${ctx}/static/plugin/bootstrap-3.3.7/css/bootstrap.min.css}"/>
	<link rel="stylesheet" href="${ctx}/static/plugin/font-awesome-4.7.0/css/font-awesome.min.css}"/>
	<link rel="stylesheet" href="${ctx}/static/plugin/Ionicons-2.0.0/css/ionicons.min.css}">
	<link rel="stylesheet" href="${ctx}/static/plugin/DataTables-1.10.15/css/dataTables.bootstrap.min.css}"/>
	<link rel="stylesheet" href="${ctx}/static/plugin/treetable-1.4.2/default/jquery.treeTable.css}"/>
	<link rel="stylesheet" href="${ctx}/static/plugin/treetable-1.4.2/vsStyle/jquery.treeTable.css}"/>
	<link rel="stylesheet" href="${ctx}/static/plugin/select2-4.0.5/css/select2.css}"/>
	<link rel="stylesheet" href="${ctx}/static/plugin/bootstrap-datetimepicker-2.4.4/css/bootstrap-datetimepicker.min.css}"/>
	<link rel="stylesheet" href="${ctx}/static/plugin/ztree-v3.5/css/metroStyle/metroStyle.css}">
	<link rel="stylesheet" href="${ctx}/static/plugin/bootstrap-fileinput-3.1.3/bootstrap-fileinput.css}">
	<link rel="stylesheet" href="${ctx}/static/plugin/AdminLTE-2.4.3/css/AdminLTE.min.css}"/>
	<link rel="stylesheet" href="${ctx}/static/plugin/AdminLTE-2.4.3/css/skins/_all-skins.min.css}"/>
	<link rel="stylesheet" href="${ctx}/static/css/style.css}"/>
	<link rel="stylesheet" href="${ctx}/static/plugin/layer/theme/default/layer.css}"/>
	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->
<body class="skin-blue sidebar-mini">
      <div class="warper">
		<div th:replace="pages/header :: header"></div>
		<div th:replace="pages/menuSider :: menuSider"></div>
		<div class="content-wrapper"></div>
		<div th:replace="pages/footer :: footer"></div>
		<div th:insert="pages/common :: commonContent"></div>
	</div>
</body>
</html>