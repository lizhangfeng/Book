package com.hzdl.book.dao.imp;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.hzdl.book.dao.UserDao;
import com.hzdl.book.entity.User;
import com.hzdl.book.uitls.C3P0Utils;

public class UserDaoImp implements UserDao {

	@Override
	public boolean exist(String userName) {

		String sql = "select * from userinfo where ULoginID=?";
		QueryRunner qRunner = new QueryRunner(C3P0Utils.getDataSource());
		try {
			User user = qRunner.query(sql, userName, new BeanHandler<>(User.class));
			if (user == null) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

}
