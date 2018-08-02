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
import com.hzdl.book.uitls.Constants;

@WebServlet("/index")
public class IndexController extends HttpServlet {

	private BookService service;
	private CategoryService categoryService;

	public IndexController() {
		service = new BookService();
		categoryService = new CategoryService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 获取带分页的图书信息
		String p = req.getParameter("pageNo");
		if (p == null || p =="") {//
			p = "1";
		}

		int pageNo = Integer.parseInt(p);

		String cid = req.getParameter("cid");
		long total = service.getBookCounts(cid);
		// 尾页
		int totalNo = (int) (total % Constants.PAGE_SIZE == 0 ? total / Constants.PAGE_SIZE : total / Constants.PAGE_SIZE + 1);

		// 上一页、下一页
		int prevNo = pageNo == 1 ? 1 : pageNo - 1;

		int nextNo = (pageNo == totalNo ? totalNo : pageNo + 1);

		//把页数放入到作用域中
		req.setAttribute("totalNo", totalNo);
		req.setAttribute("prevNo", prevNo);
		req.setAttribute("nextNo", nextNo);
		req.setAttribute("pageNo", pageNo);
		req.setAttribute("total", total);
		
		//获取本页的数据
		List<Book> books = service.getBooksByCID(cid, pageNo);
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
