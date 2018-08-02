package com.hzdl.book.service;

import java.util.List;

import com.hzdl.book.dao.BookDao;
import com.hzdl.book.dao.imp.BookDaoImp;
import com.hzdl.book.entity.Book;

public class BookService {

	private BookDao bookDao;

	public BookService() {
		super();
		bookDao = new BookDaoImp();
	}

	public List<Book> getBooksByCID(String cid) {
		return bookDao.getBooksByCID(cid);
	}
	
	public List<Book> getBooksByCID(String cid,int pageNo) {
		return bookDao.getBooksByCID(cid,pageNo);
	}
	
	public List<Book> searchBooks(String condition) {
		return bookDao.searchBooks(condition);
	}

	
	public long getBookCounts(String cid) {
		return bookDao.getBookCounts(cid);
	}
	
	public boolean deleteBookById(String BID) {
		return bookDao.deleteBookById(BID);
	}
	
	public boolean addBook(Book book) {
		return bookDao.addBook(book);
	}
	
	public Book getBookByID(String BID) {
		return bookDao.getBookByID(BID);
	}
	
	public boolean changeBook(Book book) {
		return bookDao.changeBook(book);
	}
	
}
