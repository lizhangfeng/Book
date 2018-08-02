package com.hzdl.book.web.controller.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hzdl.book.service.UserService;

@WebServlet("/user/*")
public class UserController extends HttpServlet {

	private UserService service;

	public UserController() {
		service = new UserService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String uri = req.getRequestURI();
		if (uri.contains("/toLogin")) {// 跳转登录页面
			req.getRequestDispatcher("/WEB-INF/jsp/common/user-login.jsp").forward(req, resp);
		} else if (uri.contains("/toRegist")) {// 跳转注册页面
			req.getRequestDispatcher("/WEB-INF/jsp/common/user-regist.jsp").forward(req, resp);
		} else if (uri.contains("/login")) {// 登录

		} else if (uri.contains("/regist")) {// 注册
			String code = req.getParameter("code");
			String rightCode = (String) req.getSession().getAttribute("code");
			if (code.equals(rightCode)) {
				req.setAttribute("msg", "验证码验证成功！");
			} else {
				req.setAttribute("msg", "验证码验证失败，请重新填写验证码！");
			}
			req.getRequestDispatcher("/WEB-INF/jsp/common/user-regist.jsp").forward(req, resp);
		} else if (uri.contains("/checkUser")) {// 检查用户名是否存在
			String userName = req.getParameter("userName");
			boolean flag = service.checkUser(userName);
			resp.getWriter().print(flag);
			resp.getWriter().close();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
