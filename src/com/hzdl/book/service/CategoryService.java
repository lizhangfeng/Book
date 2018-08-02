package com.hzdl.book.service;

import java.util.List;

import com.hzdl.book.dao.CategoryDao;
import com.hzdl.book.dao.imp.CategoryDaoImp;
import com.hzdl.book.entity.BaseResult;
import com.hzdl.book.entity.Category;

public class CategoryService {

	private CategoryDao dao;

	public CategoryService() {
		super();
		dao = new CategoryDaoImp();
	}

	public List<Category> getAllCategories() {
		return dao.getAllCategories();
	}

	/**
	 * 删除分类
	 * 
	 * @param cid
	 * @return
	 */
	public String deleteCategory(String cid) {
		if (dao.hasBooks(cid)) {
			return "删除失败，改分类下有图书！";
		} else {
			dao.deleteCategory(cid);
			return "删除成功";
		}
	}

	public BaseResult addCategory(String CName) {
		if (dao.existCategory(CName)) {
			return new BaseResult(201, "该分类已经 存在，请换一个分类名称试试！");
		} else {
			if (dao.addCategory(CName)) {
				return new BaseResult(200, "添加分类成功");
			} else {
				return new BaseResult(202, "添加分类失败！");
			}
		}
	}

}
