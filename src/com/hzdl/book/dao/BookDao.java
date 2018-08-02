package com.hzdl.book.dao;

import java.util.List;

import com.hzdl.book.entity.Book;

public interface BookDao {

//	List<Book> getAllBooks();
	//根据类别id获取图书
	List<Book> getBooksByCID(String cid);
	
	Book getBookByID(String BID);
	
	//带分页的
	List<Book> getBooksByCID(String cid,int pageNo);

	//根据搜索内容搜索图书
	List<Book> searchBooks(String condition);
	
	//获取所有图书的数量
	long getBookCounts(String cid);
	
	boolean deleteBookById(String BID);
	//添加图书
	boolean addBook(Book book);
	//编辑图书
	boolean changeBook(Book book);
	
}
