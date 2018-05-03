<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>myCalInterface.jsp</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function checkNum(){
			var num1=document.getElementById("num1").value;
			var num2=document.getElementById("num2").value;
			if(num1==""||num2==""){
				window.alert("输入不能为空！");
				return false;
			}
			var reg=/^[1-9]\d*(\.[0-9]+)?$|^0$/i;
			if(!reg.test(num1)||!reg.test(num2)){
				window.alert("输入的不是一个数！");
				return false;
			}
		}
	</script>
  </head>
  
  <body>
    <form action="/myJSP/demo/result.jsp" method="post" onsubmit="return checkNum()">
    	请输入第一个数：<input type="text" name="num1" id="num1" /><br/>
    	请输入第二个数：<input type="text" name="num2" id="num2" /><br/>
    	请选择运算符：<input type="radio" name="operator" checked="checked" value="+">+
    	<input type="radio" name="operator" value="-">-
    	<input type="radio" name="operator" value="*">*
    	<input type="radio" name="operator" value="/">/<br/>
    	<input type="submit" value="计算" />
    </form>
  </body>
</html>
