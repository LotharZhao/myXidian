<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
	<title>valueStack</title>
 </head>

 <body>
 	<s:property value="'haha'.length()"/>
 	
	<!-- 使用static2标签查看值栈结构 -->
	<s:debug></s:debug>
	
	获取字符串值：
	<s:property value="name"/><hr>
	
	获取对象的值：
	<s:property value="user"/><br>
	<s:property value="user.username"/>
	<s:property value="user.password"/>
	<s:property value="user.address"/><hr>
	
	获取list的值：<br>
	第一种方式：
	<s:property value="list[0]"/>
	<s:property value="list[0].username"/>
	<s:property value="list[1].username"/><br>
	第二种方式：
	<s:iterator value="list">
		<s:property value="username"/>
		<s:property value="password"/>
		<s:property value="address"/>
	</s:iterator><br>
	第三种方式：
	<s:iterator value="list" var="user">
		<s:property value="#user.username"/>
		<s:property value="#user.password"/>
		<s:property value="#user.address"/>
	</s:iterator><hr>
	
	使用foreach标签+el表达式获取值栈list集合数据：
	<c:forEach items="${list }" var="user">
		${user.username }
		${user.password }
		${user.address }
	</c:forEach><hr>
	
	<!-- 获取set方法设置的值 -->
	<s:property value="zhao"/><br>
	<!-- 获取push方法设置的值 -->
	<s:property value="[0].top"/>
 </body>
</html>
