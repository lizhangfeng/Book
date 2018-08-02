package com.hzdl.book.entity;

/**
 * 图书类别
 *
 */
public class Category {

	private int CID;
	private String CName;

	public int getCID() {
		return CID;
	}

	public void setCID(int cID) {
		CID = cID;
	}

	public String getCName() {
		return CName;
	}

	public void setCName(String cName) {
		CName = cName;
	}

	
	public Category() {
		super();
	}

	public Category(int cID, String cName) {
		super();
		CID = cID;
		CName = cName;
	}

	@Override
	public String toString() {
		return "Category [CID=" + CID + ", CName=" + CName + "]";
	}

}
