<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>ok</title>
  </head>
  
  <body>
	<hr>
	<h2>登录成功</h2>
	${sessionScope.username }+ ${sessionScope.password }
	<hr>
	
	<form action="${ pageContext.request.contextPath }/logout.action" method="post">
		<input type="submit" value="退出登录" >
	</form>
  </body>
</html>
