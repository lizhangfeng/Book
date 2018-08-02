package com.hzdl.book.web.controller.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hzdl.book.entity.Admin;
import com.hzdl.book.service.AdminService;
import com.hzdl.book.uitls.DateUtils;

@WebServlet("/admin/*")
public class AdminController extends HttpServlet {

	private AdminService service;

	public AdminController() {
		service = new AdminService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String uri = req.getRequestURI();
		if (uri.contains("/loginForm")) {// 跳转登录
			loginForm(req, resp);
		} else if (uri.contains("/login")) {// 管理员登录
			login(req, resp);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	/**
	 * 登录操作
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String loginId = req.getParameter("loginId");
		String loginPwd = req.getParameter("loginPwd");
		String rememberMe = req.getParameter("rememberMe");
		System.out.println("" + rememberMe);
		Admin admin = service.login(loginId, loginPwd);

		if ("checked".equals(rememberMe) || "on".equals(rememberMe)) {// 如果记住了用户名和密码就把用户名和密码放到cookie中
			Cookie cookie = new Cookie("loginId", loginId);
			cookie.setMaxAge(60 * 60 * 24 * 7);
			Cookie cookie2 = new Cookie("loginPwd", loginPwd);
			cookie2.setMaxAge(60 * 60 * 24 * 7);
			resp.addCookie(cookie);
			resp.addCookie(cookie2);
		}

		if (admin != null) {
			// 登录成功，把Admin存储到Session中
			req.getSession().setAttribute("admin", admin);
			req.getSession().setAttribute("loginTime", DateUtils.getNowTime());
			req.getRequestDispatcher("/manager/home").forward(req, resp);
		} else {// 登录失败，转发到登录页面
			req.setAttribute("errorMsg", "账户名或密码不正确，请重新输入！");
			loginForm(req, resp);
		}
	}

	private void loginForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/manager/admin-login.jsp").forward(req, resp);
	}

}
