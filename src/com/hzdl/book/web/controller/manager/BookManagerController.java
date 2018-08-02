package com.hzdl.book.web.controller.manager;

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
import com.jspsmart.upload.File;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

@WebServlet("/bookmgr/*")
public class BookManagerController extends HttpServlet {

	private BookService service;
	private CategoryService categoryService;
	
	public BookManagerController() {
		service = new BookService();
		categoryService = new CategoryService();
	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		if (uri.contains("/getAll")) {//获取所有图书
			getAll(req, resp);
		}else if(uri.contains("/delete")) {//删除图书
			delete(req, resp);
		}else if(uri.contains("/add")) {//添加图书
			addBook(req, resp);
		}else if(uri.contains("/goEdit")) {//跳转编辑页面
			goEdit(req, resp);
		}else if(uri.contains("/edit")) {//编辑图书
			edit(req, resp);
		}
	}


	private void goEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String BID = req.getParameter("BID");
		Book book = service.getBookByID(BID);
		req.setAttribute("book", book);
		getAllCategories(req, resp);
		req.getRequestDispatcher("/WEB-INF/jsp/manager/book-edit.jsp").forward(req, resp);
	}


	private void addBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SmartUpload su = new SmartUpload();
		su.initialize(getServletConfig(), req, resp);
		su.setAllowedFilesList("jpg,jpeg,png,gif");
		try {
			su.upload();
			
			File file = su.getFiles().getFile(0);
			String savePath = "/photo/";
			String bPhoto = file.getFileName();
			file.saveAs(savePath+bPhoto,File.SAVEAS_AUTO);
			
			Request request = su.getRequest();
			String bTitle = request.getParameter("BTitle");
			String bAuthor = request.getParameter("BAuthor");
			String bPrice = request.getParameter("BPrice");
			String bCategoryID = request.getParameter("BCategoryID");
			String bPublisher = request.getParameter("BPublisher");
			//添加到数据库中
			Book book = new Book(bTitle, bAuthor, bPrice, bCategoryID, bPublisher, bPhoto);
			service.addBook(book);
			//重新刷新页面
			req.getRequestDispatcher("/bookmgr/getAll").forward(req, resp);
			
		} catch (SmartUploadException e) {
			if (e.getMessage().contains("1105")) {
				req.setAttribute("msg", "文件太大！");
			} else if (e.getMessage().contains("1010")) {
				req.setAttribute("msg", "只允许上传jpeg,gif,png格式的文件！");
			} else if (e.getMessage().contains("1120")) {
				req.setAttribute("msg", "文件名格式错误！");
			}
		}
	}

	/**
	 * 编辑
	 * @param req
	 * @param resp
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SmartUpload su = new SmartUpload();
		su.initialize(getServletConfig(), req, resp);
		su.setAllowedFilesList("jpg,jpeg,png,gif");
		try {
			su.upload();
			
			File file = su.getFiles().getFile(0);
			if (!file.isMissing()) {//如果选中了图片才保存
				String savePath = "/photo/";
				String bPhoto = file.getFileName();
				file.saveAs(savePath+bPhoto,File.SAVEAS_AUTO);
			}
			
			Request request = su.getRequest();
			String BID = request.getParameter("BID");
			String bTitle = request.getParameter("BTitle");
			String bAuthor = request.getParameter("BAuthor");
			String bPrice = request.getParameter("BPrice");
			String bCategoryID = request.getParameter("BCategoryID");
			String bPublisher = request.getParameter("BPublisher");
			String bPhoto = request.getParameter("bphoto");
			//更新数据库中的数据
			Book book = new Book(bTitle, bAuthor, bPrice, bCategoryID, bPublisher, bPhoto);
			book.setBID(Integer.parseInt(BID));
			
			service.changeBook(book);
			//重新刷新页面
			req.getRequestDispatcher("/bookmgr/getAll").forward(req, resp);
			
		} catch (SmartUploadException e) {
			if (e.getMessage().contains("1105")) {
				req.setAttribute("msg", "文件太大！");
			} else if (e.getMessage().contains("1010")) {
				req.setAttribute("msg", "只允许上传jpeg,gif,png格式的文件！");
			} else if (e.getMessage().contains("1120")) {
				req.setAttribute("msg", "文件名格式错误！");
			}
		}
	}
	

	private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String BID = req.getParameter("BID");
		service.deleteBookById(BID);
		//删除成功，刷新页面
		req.getRequestDispatcher("/bookmgr/getAll").forward(req, resp);
	}


	private void getAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cid = req.getParameter("cid");
		long total = service.getBookCounts(cid);
		
		Page page = new Page((int)total, req);
		
		//获取本页的数据
		List<Book> books = service.getBooksByCID(cid, page.getPageNo());
		req.setAttribute("books", books);
		//获取所有分类信息
		getAllCategories(req, resp);
		
		req.getRequestDispatcher("/WEB-INF/jsp/manager/book-mgr.jsp").forward(req, resp);
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
