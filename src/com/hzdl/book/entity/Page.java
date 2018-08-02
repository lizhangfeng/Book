package com.hzdl.book.entity;

import javax.servlet.http.HttpServletRequest;

import com.hzdl.book.uitls.Constants;

/**
 * 分页类
 * @author Administrator
 *
 */
public class Page {

	private int pageNo;
	private int totalNo;
	private int prevNo;
	private int nextNo;

	public Page(int total, HttpServletRequest req) {
		// 获取带分页的图书信息
		String p = req.getParameter("pageNo");
		if (p == null || p == "") {//
			p = "1";
		}

		pageNo = Integer.parseInt(p);

		// 尾页
		totalNo = total % Constants.PAGE_SIZE == 0 ? total / Constants.PAGE_SIZE : total / Constants.PAGE_SIZE + 1;

		// 上一页、下一页
		prevNo = pageNo == 1 ? 1 : pageNo - 1;

		nextNo = (pageNo == totalNo ? totalNo : pageNo + 1);

		// 把页数放入到作用域中
		req.setAttribute("totalNo", totalNo);
		req.setAttribute("prevNo", prevNo);
		req.setAttribute("nextNo", nextNo);
		req.setAttribute("pageNo", pageNo);
		req.setAttribute("total", total);

	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getTotalNo() {
		return totalNo;
	}

	public void setTotalNo(int totalNo) {
		this.totalNo = totalNo;
	}

	public int getPrevNo() {
		return prevNo;
	}

	public void setPrevNo(int prevNo) {
		this.prevNo = prevNo;
	}

	public int getNextNo() {
		return nextNo;
	}

	public void setNextNo(int nextNo) {
		this.nextNo = nextNo;
	}

}
