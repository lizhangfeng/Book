<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>汇智动力图书网</title>
<link type="text/css" rel="stylesheet" href="${path }/css/styles.css" />
</head>
<body>
	<div id="container">
		<div id="header">
			<div id="tool-bar">
				&nbsp;&nbsp; 欢迎光临汇智动力图书网， [<a href="user-login.html">请登录</a>]&nbsp;[<a
					href="user-regist.html">免费注册</a>]&nbsp;&nbsp;&nbsp;<a
					href="index.html">首页</a>&nbsp;|&nbsp;<a href="cart.html">购物车</a>&nbsp;|&nbsp;<a
					href="#">我的订单</a>&nbsp;|&nbsp;<a href="#">帮助</a>
			</div>
			<h1>
				汇智动力图书网-<span
					style="font-size: 48px; font-family: Arial; font-weight: lighter;">Book</span>
			</h1>
		</div>
		<div id="main">
			<div class="box" id="register">
				<div class="title">用户登录</div>
				<form action="${path }/user/login" method="post" style="margin: 10px;">
					<table cellspacing="0" class="no-border">
						<tr>
							<td style="text-align: right;">登录账号：</td>
							<td><input type="text" name="loginId" class="txt" value="" /></td>
						</tr>
						<tr>
							<td style="text-align: right;">登录密码：</td>
							<td><input type="password" name="loginPsw" class="txt"
								value="" /></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td><input type="submit" value=" 登  录 " class="btn" />&nbsp;&nbsp;</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<div id="footer">
			<p>版权所有&copy;汇智动力教育</p>
		</div>
	</div>
</body>
</html>
</html>