<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>login</title>
  </head>
  
  <body>
     <form action="${ pageContext.request.contextPath }/login.action" method="post">
    	username:<input type="text" name="username"><br>
    	password:<input type="password" name="password"><br>
    	<input type="submit" value="登陆">
    </form>
  </body>
</html>
