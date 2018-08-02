package com.hzdl.book.entity;

/**
 * 管理员entity
 *
 */
public class Admin {

	private int AID;
	private String ALoginID;
	private String ALoginPsw;
	private String AName;
	public int getAID() {
		return AID;
	}
	public void setAID(int aID) {
		AID = aID;
	}
	public String getALoginID() {
		return ALoginID;
	}
	public void setALoginID(String aLoginID) {
		ALoginID = aLoginID;
	}
	public String getALoginPsw() {
		return ALoginPsw;
	}
	public void setALoginPsw(String aLoginPsw) {
		ALoginPsw = aLoginPsw;
	}
	public String getAName() {
		return AName;
	}
	public void setAName(String aName) {
		AName = aName;
	}
	@Override
	public String toString() {
		return "Admin [AID=" + AID + ", ALoginID=" + ALoginID + ", ALoginPsw=" + ALoginPsw + ", AName=" + AName + "]";
	}
	
	
}
