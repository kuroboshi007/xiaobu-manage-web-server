<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="basePath" value='${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/'/>


<script type="text/javascript" src="${ctx}/static/plugin/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${ctx}/static/plugin/layer/layer.js"></script>



<link href="${ctx}/static/plugin/layer/theme/default/layer.css" rel="stylesheet" type="text/css"/>