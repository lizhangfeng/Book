package com.hzdl.book.web.controller.common;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hzdl.book.entity.Book;
import com.hzdl.book.entity.Page;
import com.hzdl.book.service.BookService;
import com.hzdl.book.service.CategoryService;
import com.hzdl.book.uitls.Constants;

@WebServlet("/index2")
public class IndexController2 extends HttpServlet {

	private BookService service;
	private CategoryService categoryService;

	public IndexController2() {
		service = new BookService();
		categoryService = new CategoryService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		String cid = req.getParameter("cid");
		long total = service.getBookCounts(cid);
		
		Page page = new Page((int)total, req);
		
		//获取本页的数据
		List<Book> books = service.getBooksByCID(cid, page.getPageNo());
		req.setAttribute("books", books);
		
		// 获取所有分类
		getAllCategories(req, resp);
		req.getRequestDispatcher("/WEB-INF/jsp/common/index.jsp").forward(req, resp);
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
		req.setAttribute("categories", categoryService.getAllCategories());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
