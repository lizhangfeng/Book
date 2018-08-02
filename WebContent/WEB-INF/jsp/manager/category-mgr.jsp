<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>图书网后台管理系统</title>
<link type="text/css" rel="stylesheet"
	href="<%=application.getContextPath()%>/css/mgr.css" />
<script type="text/javascript" src="${path }/js/json_parse.js"></script>
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
					href="<%=application.getContextPath()%>/manager/book-mgr">图书管理</a></li>
				<li><a href="#">购书订单管理</a></li>
			</ul>
		</div>
		<div id="main">
			<div class="section-left">
				<h2>图书分类信息</h2>
				<table id="addC" class="table" cellspacing="0">
					<tr>
						<td class="header" width="200">图书分类</td>
						<td class="header" width="60">操作</td>
					</tr>
					<c:forEach items="${categories}" var="cat">
						<tr id="${cat.CID }">
							<td>${cat.CName}</td>
							<td><a href="#" onclick="deleteCategory(${cat.CID})">删除</a></td>
						</tr>
					</c:forEach>

				</table>

				${msg}

			</div>
			<div class="section-right">
				<h2>添加分类信息</h2>
				<p>
					分类名称：<input type="text" name="CName" /><input type="button" onclick="saveCategory()"
						value=" 保 存 " />
				</p>
			</div>
			<div class="cf"></div>
		</div>
		<div id="footer">
			<p>版权所有&copy;汇智动力教育</p>
		</div>
	</div>

	<script type="text/javascript">
		//删除分类
		function deleteCategory(cid){
			
			var xmlhttp = new XMLHttpRequest();
			xmlhttp.onreadystatechange = function() {

				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
					var result = xmlhttp.responseText;
					var rs = JSON.parse(result);
					if(rs.errCode == 200){
						var tr = document.getElementById(cid);
						tr.parentElement.removeChild(tr);
						//tr.parentNode.remove(tr);
					}
					alert(rs.errMsg);
				}

			}
			xmlhttp.open("GET", "${path}/category2/delete?cid=" + cid,
					true);
			xmlhttp.send();
			
		}
		//添加分类
		function saveCategory(){
			var CName = document.getElementsByName("CName")[0].value;
			var xmlhttp = new XMLHttpRequest();
			xmlhttp.onreadystatechange = function() {

				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
					var result = xmlhttp.responseText;
					var bs = JSON.parse(result);
					if(bs.errCode ==200){
						var addC = document.getElementById("addC");
						addC.innerHTML += "<tr id=''><td>"+CName+"</td><td><a href='#' onclick='deleteCategory()'>删除</a></td></tr>";;
						alert(bs.errMsg);
					}else{
						alert(bs.errMsg);
					}
				}

			}
			xmlhttp.open("GET", "${path}/category2/add?CName=" + CName,
					true);
			xmlhttp.send();
		}
	
	</script>

</body>
</html>
