<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
	<title>context</title>
 </head>

 <body>
 	<!-- 获取context里面数据 -->
 	<s:property value="#request.req"/><br>
 	
 	<input type="text" name="username" value="${req }"><br>
 	<s:textfield name="password" value="%{#request.req}"></s:textfield>
 </body>
</html>
