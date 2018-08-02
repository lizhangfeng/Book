package com.hzdl.book.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
/**
 * 监听应用的
 * @author Administrator
 *
 */
@WebListener
public class ApplicationListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		/**
		 * 1.关闭tomcat（包括异常关闭）
		 * 2.重启tomcat
		 * 3.你把项目从tomcat移除了
		 */
		System.out.println("++++++++++++++application销毁！");
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		//tomcat启动的时候就会创建触发这个监听器了
		System.out.println("++++++++++++++application创建了！");
		String path = event.getServletContext().getContextPath();
		event.getServletContext().setAttribute("path", path);
	}

}
