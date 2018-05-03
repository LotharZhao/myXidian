<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>map</title>
  </head>
  
  <body>
    <form action="${ pageContext.request.contextPath }/map.action" method="post">
    	<!-- 设置key值：map['key值'] -->
    	username1:<input type="text" name="map['one'].username"><br>
    	password1:<input type="text" name="map['one'].password"><br>
    	address1:<input type="text" name="map['one'].address"><br>
    	<hr>
    	username2:<input type="text" name="map['two'].username"><br>
    	password2:<input type="text" name="map['two'].password"><br>
    	address2:<input type="text" name="map['two'].address"><br>
    	<input type="submit" value="提交">
    </form>
  </body>
</html>
