package com.hzdl.book.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.hzdl.book.dao.CategoryDao;
import com.hzdl.book.entity.Category;
import com.hzdl.book.uitls.C3P0Utils;

public class CategoryDaoImp implements CategoryDao {

	@Override
	public List<Category> getAllCategories() {

		String sql = "select * from categoryinfo";
		QueryRunner qRunner = new QueryRunner(C3P0Utils.getDataSource());
		List<Category> categories = null;
		try {
			categories = qRunner.query(sql, new BeanListHandler<>(Category.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categories;
	}

	@Override
	public boolean hasBooks(String cid) {

		String sql = "select count(*) from bookinfo where BCategoryID=?";
		QueryRunner qRunner = new QueryRunner(C3P0Utils.getDataSource());
		try {
			long count = (long) qRunner.query(sql, cid, new ScalarHandler());
			if (count > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean deleteCategory(String cid) {
		String sql = "delete from categoryinfo where CID=?";
		QueryRunner qRunner = new QueryRunner(C3P0Utils.getDataSource());
		try {
			qRunner.update(sql, cid);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean addCategory(String CName) {
		String sql = "insert into categoryinfo(CName) values(?)";

		try {
			Connection conn = C3P0Utils.getDataSource().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, CName);
			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();

			while(rs.next()){
				int cid = rs.getInt(1);
				System.out.println("cid: " + cid);
			}
			return true;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		// QueryRunner qRunner = new QueryRunner(C3P0Utils.getDataSource());
		// try {
		// qRunner.update(sql, CName);
		// return true;
		// } catch (SQLException e) {
		// e.printStackTrace();
		// }
		return false;
	}

	@Override
	public boolean existCategory(String CName) {
		String sql = "select * from categoryinfo where CName=?";
		QueryRunner qRunner = new QueryRunner(C3P0Utils.getDataSource());
		List<Category> categories = null;
		try {
			categories = qRunner.query(sql, CName, new BeanListHandler<>(Category.class));
			if (categories == null || categories.isEmpty()) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

}
