<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>result.jsp</title>
    
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
  	<%
  		double num1=Double.parseDouble(request.getParameter("num1"));
  		double num2=Double.parseDouble(request.getParameter("num2"));
  		String operator = request.getParameter("operator");
  		double result=0;
  		if(operator.equals("+")){
  			result=num1+num2;
  		}else if(operator.equals("-")){
  			result=num1-num2;
  		}else if(operator.equals("*")){
  			result=num1*num2;
  		}else if(operator.equals("/")){
  			result=num1/num2;
  		}
  		out.print("结果是："+result);
  	 %>
  </body>
</html>
