package com.hzdl.book.web.controller.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hzdl.book.entity.BaseResult;
import com.hzdl.book.service.CategoryService;

/**
 * Ajax处理分类管理相关请求
 */
@WebServlet("/category2/*")
public class CategoryController2 extends HttpServlet {

	private CategoryService service;

	public CategoryController2() {
		service = new CategoryService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String uri = req.getRequestURI();
		if (uri.contains("/delete")) {// 删除分类
			String cid = req.getParameter("cid");
			String errorMsg = service.deleteCategory(cid);
			
			JSONObject object = new JSONObject();
			if("删除成功".equals(errorMsg)) {
				object.put("errCode", 200);
			}else {
				object.put("errCode", 201);
			}
			object.put("errMsg", errorMsg);
			
			resp.getWriter().println(object.toJSONString());
			resp.getWriter().close();

		} else if (uri.contains("/add")) {//添加分类
			String CName = req.getParameter("CName");
			BaseResult result = service.addCategory(CName);
			
			/*
			 * 方法1. 通过CName从数据库中查处cid
			 * 方法2. 插入成功获取自增长id
			 */
			
			resp.getWriter().println(JSONObject.toJSONString(result));
			resp.getWriter().close();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
