package com.entity;

public class UTO{

	private int num;
	private String userID;
	private String userPassword;
	private String userName;
	private String userTell;
	
	public UTO(){}
	public UTO(int num,String userID ,String userPassword,String userName,String userTell) {
		this.num = num;
		this.userID = userID;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userTell = userTell;	
	}
	public String getuserID() {
		return userID;
	}
	public String getuserPassword() {
		return userPassword;
	}	
	public String getuserName() {
		return userName;
	}	
	public String getuserTell() {
		return userTell;
	}
	public void setuserID(String userID) {
		this.userID = userID;
	}
	public void setuserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public void setuserName(String userName) {
		this.userName = userName;
	}
	public void setuserTell(String userTell) {
		this.userTell = userTell;
	}
	public int getNum() {
		return this.num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}
