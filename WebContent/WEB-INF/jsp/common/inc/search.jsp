<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="search-bar"
		action="<%=application.getContextPath()%>/book/search" method="post">
		书名：<input type="text" class="txt" name="condition"
			value="${condition }" /> <input id="search-btn" type="submit"
			value=" 搜索图书 " />
	</form>

	<!-- 敲回车键 搜索图书-->
	<script type="text/javascript">
		document.onkeydown = function(event) {
			var e = event || window.event;
			if (e && e.keyCode == 13) { // 回车键的键值为13
				document.getElementById("#search-btn").click(); // 调用登录按钮的登录事件
			}
		};
	</script>
</body>
</html>