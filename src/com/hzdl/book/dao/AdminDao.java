package com.hzdl.book.dao;

import com.hzdl.book.entity.Admin;

public interface AdminDao {

	Admin getAdminByNameAndPwd(String name,String pwd);
}
