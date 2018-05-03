<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>form</title>
  </head>
  
  <body>
    <form action="${ pageContext.request.contextPath }/form4.action" method="post">
    	username:<input type="text" name="username"><br>
    	password:<input type="text" name="password"><br>
    	address:<input type="text" name="address"><br>
    	<input type="submit" value="提交">
    </form>
  </body>
</html>
