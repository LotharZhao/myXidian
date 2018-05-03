<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>list</title>
  </head>
  
  <body>
    <form action="${ pageContext.request.contextPath }/list.action" method="post">
    	<!-- list[0] 表示list集合中的第一个user对象 -->
    	username1:<input type="text" name="list[0].username"><br>
    	password1:<input type="text" name="list[0].password"><br>
    	address1:<input type="text" name="list[0].address"><br>
    	<hr>
    	username2:<input type="text" name="list[1].username"><br>
    	password2:<input type="text" name="list[1].password"><br>
    	address2:<input type="text" name="list[1].address"><br>
    	<input type="submit" value="提交">
    </form>
  </body>
</html>
