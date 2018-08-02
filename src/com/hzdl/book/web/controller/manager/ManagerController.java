package com.hzdl.book.web.controller.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hzdl.book.service.CategoryService;

@WebServlet("/manager/*")
public class ManagerController extends HttpServlet {

	private CategoryService service;

	public ManagerController() {
		service = new CategoryService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		String url = "";
		if (uri.contains("/home")) {// 后台首页
			url = "/WEB-INF/jsp/manager/admin-home.jsp";
		} else if (uri.contains("/category-mgr")) {// 跳转图书分类管理
			getAllCategories(req, resp);
			url = "/WEB-INF/jsp/manager/category-mgr.jsp";
		} else if (uri.contains("/book-mgr")) {// 跳转图书管理
			url = "/WEB-INF/jsp/manager/book-mgr.jsp";
		} else if (uri.contains("/help")) {
			url = "/WEB-INF/jsp/manager/help.jsp";
		}
		if (url != "" || url != null) {
			req.getRequestDispatcher(url).forward(req, resp);
		}
	}

	/**
	 * 获取所有分类
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private void getAllCategories(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setAttribute("categories", service.getAllCategories());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
