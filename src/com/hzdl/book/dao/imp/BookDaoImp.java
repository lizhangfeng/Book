package com.hzdl.book.dao.imp;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.hzdl.book.dao.BookDao;
import com.hzdl.book.entity.Book;
import com.hzdl.book.uitls.C3P0Utils;
import com.hzdl.book.uitls.Constants;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class BookDaoImp implements BookDao {

	private QueryRunner qRunner;

	public BookDaoImp() {
		qRunner = new QueryRunner(C3P0Utils.getDataSource());
	}

	@Override
	public List<Book> getBooksByCID(String cid) {
		String sql;
//		QueryRunner qRunner = new QueryRunner(C3P0Utils.getDataSource());
		List<Book> books = null;
		if (cid == null || cid == "") {// 获取所有的图书
			sql = "select *,c.CName categoryName from bookinfo b left join categoryinfo c on b.BCategoryID=c.CID";
			try {
				books = qRunner.query(sql, new BeanListHandler<>(Book.class));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {// 根据分类获取图书
			sql = "select *,c.CName categoryName from bookinfo b left join categoryinfo c on b.BCategoryID=c.CID where b.BCategoryID=?";
			try {
				books = qRunner.query(sql, cid, new BeanListHandler<>(Book.class));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return books;
	}

	@Override
	public List<Book> searchBooks(String condition) {

		String sql = "select *,c.CName categoryName from bookinfo b left join categoryinfo c on b.BCategoryID=c.CID where BTitle like '%"
				+ condition + "%'";
//		QueryRunner qRunner = new QueryRunner(C3P0Utils.getDataSource());
		List<Book> books = null;
		try {
			books = qRunner.query(sql, new BeanListHandler<>(Book.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public long getBookCounts(String cid) {
		String sql = "";
		if (cid == null || cid == "") {
			sql = "select count(*) from bookinfo";
		} else {
			sql = "select count(*) from bookinfo where BCategoryID=" + cid;
		}

		QueryRunner qRunner = new QueryRunner(C3P0Utils.getDataSource());
		try {
			return qRunner.query(sql, new ScalarHandler<>());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Book> getBooksByCID(String cid, int pageNo) {
		String sql;
//		QueryRunner qRunner = new QueryRunner(C3P0Utils.getDataSource());
		List<Book> books = null;
		if (cid == null || cid == "") {// 获取所有的图书
			sql = "select *,c.CName categoryName from bookinfo b left join categoryinfo c on b.BCategoryID=c.CID limit ?,?";
			try {
				books = qRunner.query(sql, new Object[] { (pageNo - 1) * Constants.PAGE_SIZE, Constants.PAGE_SIZE },
						new BeanListHandler<>(Book.class));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {// 根据分类获取图书
			sql = "select *,c.CName categoryName from bookinfo b left join categoryinfo c on b.BCategoryID=c.CID where b.BCategoryID=? limit ?,?";
			try {
				books = qRunner.query(sql,
						new Object[] { cid, (pageNo - 1) * Constants.PAGE_SIZE, Constants.PAGE_SIZE },
						new BeanListHandler<>(Book.class));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return books;
	}

	@Override
	public boolean deleteBookById(String BID) {
		String sql = "delete from bookinfo where BID=?";
//		QueryRunner qRunner = new QueryRunner(C3P0Utils.getDataSource());
		try {
			qRunner.update(sql, BID);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean addBook(Book book) {

		String sql = "insert into bookinfo values(null,?,?,?,?,?,?)";

		try {
			qRunner.update(sql, book.BTitle,book.BAuthor,book.BPrice,book.BCategoryID,book.BPublisher,book.BPhoto);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public Book getBookByID(String BID) {
		String sql = "select * from bookinfo where BID=?";
		try {
			Book book = qRunner.query(sql,BID, new BeanHandler<>(Book.class));
			return book;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean changeBook(Book book) {
		
		String sql = "update bookinfo set BTitle=?,BAuthor=?,BPrice=?,BCategoryID=?,BPublisher=?,BPhoto=? where BID=?";
		try {
			qRunner.update(sql, book.getBTitle(),book.getBAuthor(),book.getBPrice(),
					book.getBCategoryID(),book.getBPublisher(),book.getBPhoto(),book.getBID());
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
