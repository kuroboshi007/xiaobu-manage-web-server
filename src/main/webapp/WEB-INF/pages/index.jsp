<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../commons/lib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>欢迎首页</title>

  </head>
  
  <body>
   欢迎  ${user.username}
   <a href="<c:url value="/login/logout"></c:url>">
	<i class="icon-key"></i> Log Out </a>
  </body>
  <script type="text/javascript">
  
    
  </script>
</html>
