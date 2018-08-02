package com.hzdl.book.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.hzdl.book.entity.Admin;

public class AdminLoginFilter implements Filter {

	//忽略拦截列表
//	String [] ignoreList = {"/manager/help","/manager/about_us"};
	
	String [] ignoreList;
	
	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;

		boolean flag = true;//默认拦截
		for (String uri : ignoreList) {
			if (req.getRequestURI().contains(uri)) {
				flag = false;//不拦截
			}
		}
		
		if (flag) {
			Admin admin = (Admin) req.getSession().getAttribute("admin");
			System.out.println(admin);
			if ( admin== null) {// 未登录转发到登录页面
				req.getRequestDispatcher("/admin/loginForm").forward(request, response);
			}
		}

		chain.doFilter(request, response);

	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		//从web.xml读取忽略列表
		ignoreList = config.getInitParameter("list").split(",");
	}

}
