package com.hzdl.book.dao;

import java.util.List;

import com.hzdl.book.entity.Category;

public interface CategoryDao {

	List<Category> getAllCategories();
	
	//判断分类下是否有数
	boolean hasBooks(String cid);
	
	//删除图书
	boolean deleteCategory(String cid);
	//添加分类
	boolean addCategory(String CName);
	// 判断分类是否存在
	boolean existCategory(String CName);
	
}
