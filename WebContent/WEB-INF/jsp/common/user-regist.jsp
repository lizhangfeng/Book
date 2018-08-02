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
				<div class="title">新用户注册</div>
				<form action="${path }/user/regist" method="post"
					style="margin: 10px;">
					<table cellspacing="0" class="no-border">
						<tr>
							<td style="text-align: right;">登录账号：</td>
							<td><input type="text" id="loginId" name="loginId"
								class="txt" value="" onblur="checkUser(this)" /> <span
								style="color: red" id="errorMsg"></span></td>
						</tr>
						<tr>
							<td style="text-align: right;">登录密码：</td>
							<td><input type="password" name="loginPsw" class="txt"
								value="" /></td>
						</tr>
						<tr>
							<td style="text-align: right;">再次输入密码：</td>
							<td><input type="password" name="reLoginPsw" class="txt"
								value="" /></td>
						</tr>
						<tr>
							<td style="text-align: right;">真实姓名：</td>
							<td><input type="text" name="name" class="txt" value="" /></td>
						</tr>
						<tr>
							<td style="text-align: right;">验证码：</td>
							<td><input type="text" name="code" class="txt" />${msg }</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td><img id="img" src="${path }/checkCode" />&nbsp;&nbsp;看不清？<a
								href="#" onclick="refreshCode()" style="color: #64A26F;">换张图</a></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td><input type="submit" value=" 注  册 " class="btn" />&nbsp;&nbsp;</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<div id="footer">
			<p>版权所有&copy;汇智动力教育</p>
		</div>
	</div>

	<script type="text/javascript">
		//失去焦点的时候触发事件
		function checkUser(obj) {
			var xmlhttp = new XMLHttpRequest();
			xmlhttp.onreadystatechange = function() {

				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
					var result = xmlhttp.responseText;

					if (result == "true") {
						//alert("用户名已存在，请换其他的吧！");
						document.getElementById("errorMsg").innerText = "用户名已存在，请换其他的吧！";
					} else {
						//alert("用户名可用");
						document.getElementById("errorMsg").innerText = "用户名可用";
					}
				}

			}
			//var userName = document.getElementById("loginId").value;
			var userName = obj.value;
			xmlhttp.open("GET", "${path}/user/checkUser?userName=" + userName,
					true);
			//xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			xmlhttp.send();
		}

		var num=0;
		
		//刷新验证码
		function refreshCode() {
			/* var xmlhttp = new XMLHttpRequest();
			xmlhttp.onreadystatechange = function() {

				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
					var result = xmlhttp.responseText;
					var img = document.getElementById("img");
					img.setAttribute("src", result);
				}

			}
			xmlhttp.open("GET", "${path}/checkCode", true);
			xmlhttp.send(); */
			num++;
			var img = document.getElementById("img");
			//img 如果src的地址一样不会重新请求
			img.setAttribute("src", "${path }/checkCode?id="+num);
			
		}
	</script>

</body>
</html>