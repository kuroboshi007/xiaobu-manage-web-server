<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="basePath" value='${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/'/>



<%-- <script type="text/javascript" src="${ctx}/static/global/plugins/bootstrap-datepicker/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript" src="${ctx}/static/global/plugins/bootstrap-datepicker/js/bootstrap-datetimepicker.fr.js"></script>
<script type="text/javascript" src="${ctx}/static/global/plugins/bootstrap-datepicker/js/bootstrap-datetimepicker.zh-CN.js"></script> 
<link href="${ctx}/static/global/plugins/bootstrap-datepicker/css/bootstrap-datepicker3.min.css" rel="stylesheet" type="text/css"/> --%>