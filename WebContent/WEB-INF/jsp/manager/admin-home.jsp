<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>图书网后台管理系统</title>
<link type="text/css" rel="stylesheet"
	href="<%=application.getContextPath()%>/css/mgr.css" />
</head>
<body>

	<div id="container">
		<div id="header">
			<h1>汇智动力教育--图书网后台管理系统</h1>
		</div>
		<div id="info">
			张三，您好！&nbsp;&nbsp;<a href="admin-user-login.html">登出</a>
		</div>
		<div class="menu">
			<ul>
				<li><a href="<%=application.getContextPath()%>/manager/home">首页</a></li>
				<li><a
					href="<%=application.getContextPath()%>/manager/category-mgr">图书分类管理</a></li>
				<li><a
					href="<%=application.getContextPath()%>/bookmgr/getAll	">图书管理</a></li>
				<li><a href="#">购书订单管理</a></li>
			</ul>
		</div>
		<div id="main">
			<div class="section-left"></div>
			<div class="section-right"></div>
			<div class="cf"></div>
		</div>
		<div id="footer">
			<p>版权所有&copy;汇智动力教育</p>
		</div>
	</div>
</body>
</html>