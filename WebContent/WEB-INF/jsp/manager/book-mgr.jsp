<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
					href="<%=application.getContextPath()%>/manager/book-mgr">图书管理</a></li>
				<li><a href="#">购书订单管理</a></li>
			</ul>
		</div>
		<div id="main">
			<div class="section-left">
				<h2>图书信息列表</h2>
				<table class="table" cellspacing="0" style="font-size: 12px;">
					<tr>
						<td class="header" width="100">书名</td>
						<td class="header" width="60">作者</td>
						<td class="header" width="60">类型</td>
						<td class="header" width="60">售价</td>
						<td class="header" width="60">操作</td>
					</tr>
					<c:forEach items="${books }" var="book">

						<tr>
							<td>${book.BTitle }</td>
							<td>${book.BAuthor }</td>
							<td>${book.categoryName }</td>
							<td>￥${book.BPrice }</td>
							<td><a
								href="<%=application.getContextPath() %>/bookmgr/delete?BID=${book.BID}">删除</a>&nbsp;<a
								href="<%=application.getContextPath() %>/bookmgr/goEdit?BID=${book.BID}">编辑</a></td>
						</tr>
					</c:forEach>

				</table>

				<div class="paging"
					style="border-bottom: 1px solid #64A26F; color: #006666;">
					<span class="fr"> <a
						href="<%=application.getContextPath()%>/bookmgr/getAll?pageNo=1">首页</a>&nbsp;
						<c:if test="${pageNo==1 }">

							<span style="color: gray; font-weight: bold;">上一页</span>&nbsp;
						</c:if> <c:if test="${pageNo != 1 }">
							<a
								href="<%=application.getContextPath() %>/bookmgr/getAll?pageNo=${prevNo}">上一页</a>&nbsp;
						</c:if> <a
						href="<%=application.getContextPath() %>/bookmgr/getAll?pageNo=${nextNo}">下一页</a>&nbsp;
						<a
						href="<%=application.getContextPath() %>/bookmgr/getAll?pageNo=${totalNo}">尾页</a>&nbsp;
					</span> 共有图书${total}本，分${totalNo }页显示，每页显示10个商品,当前页数为${pageNo }
				</div>

			</div>
			<div class="section-right">
				<h2>添加图书信息</h2>
				<form action="<%=application.getContextPath()%>/bookmgr/add"
					method="post" enctype="multipart/form-data">
					<p>
						图书书名：<input type="text" name="BTitle" />
					</p>
					<p>
						图书作者：<input type="text" name="BAuthor" />
					</p>
					<p>
						图书分类： <select name="BCategoryID">
							<c:forEach items="${categories }" var="cat">
								<option value="${cat.CID }">${cat.CName }</option>
							</c:forEach>
						</select>
					</p>
					<p>
						图书售价：<input type="text" name="BPrice" />
					</p>
					<p>
						图书出版社：<input type="text" name="BPublisher" />
					</p>
					<p>
						图书图片：<input type="file" name="filename" />
					</p>
					<p>
						<input type="submit" value=" 保 存 " />
					</p>
				</form>

				<span style="color: red; font-weight: bold">${msg}</span>
			</div>
			<div class="cf"></div>
		</div>
		<div id="footer">
			<p>版权所有&copy;汇智动力教育</p>
		</div>
	</div>
</body>
</html>
