package com.hzdl.book.entity;

public class Book {

	public int BID;
	public String BTitle;
	public String BAuthor;
	public String BPrice;
	public String BCategoryID;
	public String BPublisher;
	public String BPhoto;

	public Book() {
		super();
	}

	public Book(String bTitle, String bAuthor, String bPrice, String bCategoryID, String bPublisher, String bPhoto) {
		super();
		BTitle = bTitle;
		BAuthor = bAuthor;
		BPrice = bPrice;
		BCategoryID = bCategoryID;
		BPublisher = bPublisher;
		BPhoto = bPhoto;
	}

	// 额外添加字段

	private String categoryName;

	public int getBID() {
		return BID;
	}

	public void setBID(int bID) {
		BID = bID;
	}

	public String getBTitle() {
		return BTitle;
	}

	public void setBTitle(String bTitle) {
		BTitle = bTitle;
	}

	public String getBAuthor() {
		return BAuthor;
	}

	public void setBAuthor(String bAuthor) {
		BAuthor = bAuthor;
	}

	public String getBPrice() {
		return BPrice;
	}

	public void setBPrice(String bPrice) {
		BPrice = bPrice;
	}

	public String getBCategoryID() {
		return BCategoryID;
	}

	public void setBCategoryID(String bCategoryID) {
		BCategoryID = bCategoryID;
	}

	public String getBPublisher() {
		return BPublisher;
	}

	public void setBPublisher(String bPublisher) {
		BPublisher = bPublisher;
	}

	public String getBPhoto() {
		return BPhoto;
	}

	public void setBPhoto(String bPhoto) {
		BPhoto = bPhoto;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "Book [BID=" + BID + ", BTitle=" + BTitle + ", BAuthor=" + BAuthor + ", BPrice=" + BPrice
				+ ", BCategoryID=" + BCategoryID + ", BPublisher=" + BPublisher + ", BPhoto=" + BPhoto
				+ ", categoryName=" + categoryName + "]";
	}

}
