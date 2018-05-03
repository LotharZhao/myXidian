<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>strutstag</title>
  </head>
  
  <body>
	<s:form>
		<s:textfield name="username" label="username"></s:textfield>
		<s:password name="password" label="password"></s:password>
		<s:radio list="{'男','女'}" name="sex" label="sex"></s:radio>
		<s:radio list="#{'xian':'西安','beijing':'北京','tianjin':'天津' }" name="sex" label="address"></s:radio>
		<s:checkboxlist list="{'吃饭','睡觉','打豆豆'}" name="hobby" label="hobby"></s:checkboxlist>
		<s:select list="{'幼儿园','小学','初中','高中','大学'}" name="level " label="level "></s:select>
		<s:file name="file" label="file"></s:file>
		<s:hidden name="hid" label="hid"></s:hidden>
		<s:textarea rows="3" cols="20" name="other" label="other"></s:textarea>
		<s:submit value="submit"></s:submit>
		<s:reset value="reset"></s:reset>
	</s:form>
  </body>
</html>
