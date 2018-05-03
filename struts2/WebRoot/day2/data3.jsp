<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>data</title>
  </head>
  
  <body>
    <form action="${ pageContext.request.contextPath }/data3.action" method="post">
    	username:<input type="text" name="user.username"><br>
    	password:<input type="text" name="user.password"><br>
    	address:<input type="text" name="user.address"><br>
    	<input type="submit" value="提交">
    </form>
  </body>
</html>
