<%@page import="com.hzdl.book.entity.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>汇智动力图书网</title>
<link type="text/css" rel="stylesheet"
	href="${path}/css/styles.css" />

</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/jsp/common/inc/header.jsp"></jsp:include>
		<jsp:include page="/WEB-INF/jsp/common/inc/search.jsp"></jsp:include>

		<div id="main">
			<div class="section-left">
				<div class="box-left">
					<div class="box-title">分类畅销榜</div>
					<div class="box-content">

						<c:if test="${ empty cid}">
							<p style="background: #FDF8CD">
								·<a href="${path}/book/getAll">全部</a>
							</p>
						</c:if>
						<c:if test="${not empty cid}">
							<p>
								·<a href="${path}/book/getAll">全部</a>
							</p>
						</c:if>

						<c:forEach items="${categories }" var="cat">

							<c:if test="${cid == cat.CID}">
								<p style="background: #FDF8CD">
									·<a
										href="${path}/book/getAll?cid=${cat.CID}">${cat.CName }</a>
								</p>
							</c:if>
							<c:if test="${not (cid == cat.CID)}">
								<p>
									·<a
										href="${path}/book/getAll?cid=${cat.CID}">${cat.CName }</a>
								</p>
							</c:if>


						</c:forEach>

					</div>
				</div>
			</div>
			<div class="section-right">
				<div class="box-right">
					<div class="box-title">您目前浏览的图书【搜索条件——分类：全部；书名：无】</div>
					<div class="paging"
						style="border-bottom: 1px solid #64A26F; color: #006666;">
						<span class="fr"> <a
							href="${path}/index?pageNo=1">首页</a>&nbsp;
							<c:if test="${pageNo==1 }">

								<span style="color: gray;font-weight: bold;">上一页</span>&nbsp;
						</c:if> <c:if test="${pageNo != 1 }">
								<a
									href="${path}/index?pageNo=${prevNo}">上一页</a>&nbsp;
						</c:if> <a
							href="${path}/index?pageNo=${nextNo}">下一页</a>&nbsp;
							<a
							href="${path}/index?pageNo=${totalNo}">尾页</a>&nbsp;
						</span> 共有图书${total}本，分${totalNo }页显示，每页显示10个商品,当前页数为${pageNo }
					</div>

					<c:forEach items="${books }" var="book">
						<div class="box-item">
							<div class="img-box">
								<img
									src="${path}/photo/${book.BPhoto}" />
							</div>
							<div class="info-box">
								<span style="font-size: 14px;"><a href="#">${book.BTitle }</a></span><br />
								作者：${book.BAuthor }&nbsp;&nbsp;著<br /> 分类：${book.categoryName }<br />
								出版社：${book.BPublisher }<br /> 售价：￥<span style="color: #990000;">${book.BPrice }</span>
								<br />
							</div>
							<a href="cart.html" class="btn-buy">购&nbsp;&nbsp;买</a>
							<div class="cf"></div>
						</div>
					</c:forEach>


					<div class="paging">
						<span class="fr"> <a
							href="${path}/index?pageNo=1">首页</a>&nbsp;
							<c:if test="${pageNo==1 }">

								<a href="javascript:void(0)">上一页</a>&nbsp;
						</c:if> <c:if test="${pageNo != 1 }">
								<a
									href="${path}/index?pageNo=${prevNo}">上一页</a>&nbsp;
						</c:if> <a
							href="${path}/index?pageNo=${nextNo}">下一页</a>&nbsp;
							<a
							href="${path}/index?pageNo=${totalNo}">尾页</a>&nbsp;
						</span> </span>
					</div>
				</div>
			</div>
			<div class="cf"></div>
		</div>
		<div id="footer">
			<p>版权所有&copy;汇智动力教育</p>
		</div>
	</div>

</body>
</html>