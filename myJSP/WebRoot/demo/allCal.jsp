<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>allCal.jsp</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
	function checkNum() {
		var reg = /^[1-9]\d*(\.[0-9]+)?$|^0$/i;
		if (!reg.test(num1) || !reg.test(num2)) {
			window.alert("输入的不是一个数！");
			return false;
		}
	}
</script>
</head>
<%
	String num1 = request.getParameter("num1");
	String num2 = request.getParameter("num2");
	String operator = request.getParameter("operator");
	double d_num1 = 0;
	double d_num2 = 0;
	double result = 0;
	if (num1 != null && num2 != null && operator != null) {
		d_num1 = Double.parseDouble(num1);
		d_num2 = Double.parseDouble(num2);

		if (operator.equals("+")) {
			result = d_num1 + d_num2;
		} else if (operator.equals("-")) {
			result = d_num1 - d_num2;
		} else if (operator.equals("*")) {
			result = d_num1 * d_num2;
		} else if (operator.equals("/")) {
			result = d_num1 / d_num2;
		}
	}
%>

<body>
	 <form action="/myJSP/demo/allCal.jsp" method="post" onsubmit="return checkNum()">
    	请输入第一个数：<input type="text" name="num1" id="num1" value="<%=d_num1 %>" /><br/>
    	请输入第二个数：<input type="text" name="num2" id="num2" value="<%=d_num2 %>" /><br/>
    	请选择运算符：<input type="radio" name="operator" checked="checked" value="+">+
    	<input type="radio" name="operator" value="-">-
    	<input type="radio" name="operator" value="*">*
    	<input type="radio" name="operator" value="/">/<br/>
    	<input type="submit" value="计算" />
    </form>
	<hr>
	结果是：<%=result%>
</body>
</html>
