package com.hzdl.book.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 编码过滤器
 * 
 * @author Administrator
 *
 */
public class EncodingFilter implements Filter {

	private String encode;

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// request.setCharacterEncoding("UTF-8");
		// response.setCharacterEncoding("UTF-8");

		//如果Request已经设置了编码那么我们就不设置
		if (request.getCharacterEncoding() == null) {
			request.setCharacterEncoding(encode);
		}
		response.setCharacterEncoding(encode);
		chain.doFilter(request, response);
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		encode = config.getInitParameter("encode");
	}

}
