package com.hzdl.book.web.controller.common;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hzdl.book.entity.Book;
import com.hzdl.book.service.BookService;
import com.hzdl.book.service.CategoryService;

@WebServlet("/book/*")
public class BookController extends HttpServlet{

	private BookService service;
	private CategoryService categoryService;
	
	public BookController() {
		service = new BookService();
		categoryService = new CategoryService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri =req.getRequestURI();
		
		if (uri.contains("/getAll")) {//获取首页所有内容
			getAllBooks(req, resp);
			getAllCategories(req, resp);
			req.getRequestDispatcher("/WEB-INF/jsp/common/index.jsp").forward(req, resp);
		}else if(uri.contains("/search")) {//搜索图书
//			req.setCharacterEncoding("utf-8");
			//根据条件模糊查询图书
			String condition =req.getParameter("condition");
			List<Book> books = service.searchBooks(condition);
			req.setAttribute("books", books);
			//把搜索的条件放入到session，给前端显示用
			req.getSession().setAttribute("condition", condition);
			//获取所有分类
			getAllCategories(req, resp);
			req.getRequestDispatcher("/WEB-INF/jsp/common/index.jsp").forward(req, resp);
		}
		
	}

	/**
	 * 获取所有分类
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private void getAllCategories(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setAttribute("categories", categoryService.getAllCategories());
	}

	/**
	 * 获取图书
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private void getAllBooks(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//从前端获取到cid
		String cid = req.getParameter("cid");
		req.setAttribute("cid", cid);
		//根据cid获取对应的图书
		List<Book> books = service.getBooksByCID(cid);
		req.setAttribute("books", books);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
