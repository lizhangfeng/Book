package com.hzdl.book.web.controller.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hzdl.book.service.CategoryService;

/**
 * 处理分类管理相关请求
 */
@WebServlet("/category/*")
public class CategoryController extends HttpServlet {

	private CategoryService service;

	public CategoryController() {
		service = new CategoryService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String uri = req.getRequestURI();
//		req.setCharacterEncoding("utf-8");
		if (uri.contains("/delete")) {// 删除分类
			String cid = req.getParameter("cid");
			String errorMsg = service.deleteCategory(cid);
			req.setAttribute("msg", errorMsg);
			req.getRequestDispatcher("/manager/category-mgr").forward(req, resp);
		}else if(uri.contains("/add")) {
			String CName= req.getParameter("CName");
//			String errorMsg = service.addCategory(CName);
//			req.setAttribute("msg", errorMsg);
			//添加成功并刷新页面
			req.getRequestDispatcher("/manager/category-mgr").forward(req, resp);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
