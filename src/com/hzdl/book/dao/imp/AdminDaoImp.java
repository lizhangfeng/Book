package com.hzdl.book.dao.imp;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.hzdl.book.dao.AdminDao;
import com.hzdl.book.entity.Admin;
import com.hzdl.book.uitls.C3P0Utils;

public class AdminDaoImp implements AdminDao {

	private QueryRunner qRunner;

	public AdminDaoImp() {
		qRunner = new QueryRunner(C3P0Utils.getDataSource());
	}

	@Override
	public Admin getAdminByNameAndPwd(String name, String pwd) {

		String sql = "select * from admininfo where ALoginID=? and ALoginPsw=?";
		try {
			Admin admin = qRunner.query(sql, new Object[] { name, pwd }, new BeanHandler<>(Admin.class));
			return admin;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
