package com.hzdl.book.entity;

public class User {

	private int UID;
	private String ULoginID;
	private String ULoginPsw;
	private String UName;
	private String UPoint;

	public int getUID() {
		return UID;
	}

	public void setUID(int uID) {
		UID = uID;
	}

	public String getULoginID() {
		return ULoginID;
	}

	public void setULoginID(String uLoginID) {
		ULoginID = uLoginID;
	}

	public String getULoginPsw() {
		return ULoginPsw;
	}

	public void setULoginPsw(String uLoginPsw) {
		ULoginPsw = uLoginPsw;
	}

	public String getUName() {
		return UName;
	}

	public void setUName(String uName) {
		UName = uName;
	}

	public String getUPoint() {
		return UPoint;
	}

	public void setUPoint(String uPoint) {
		UPoint = uPoint;
	}

	@Override
	public String toString() {
		return "User [UID=" + UID + ", ULoginID=" + ULoginID + ", ULoginPsw=" + ULoginPsw + ", UName=" + UName
				+ ", UPoint=" + UPoint + "]";
	}

}
