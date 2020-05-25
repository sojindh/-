package com.entity;

public class BoardRTO {

	int num;
	String grade;
	String Title;
	String major;
	String classname;
	String price;
	String content;
	int readcnt;
	String writeday;
	String userID;
	
	public BoardRTO() {}
	public BoardRTO(int num, String grade, String Title, String major, String classname, String price, String content,
			int readcnt, String writeday,String userID) {
		this.num = num;
		this.grade = grade;
		this.Title = Title;
		this.major = major;
		this.classname = classname;
		this.price = price;
		this.content = content;
		this.readcnt = readcnt;
		this.writeday = writeday;
		this.userID = userID;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getgrade() {
		return grade;
	}
	public void setgrade(String grade) {
		this.grade = grade;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String Title) {
		this.Title = Title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReadcnt() {
		return readcnt;
	}
	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}
	public String getWriteday() {
		return writeday;
	}
	public void setWriteday(String writeday) {
		this.writeday = writeday;
	}
	
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getclassname() {
		return classname;
	}
	public void setclassname(String classname) {
		this.classname = classname;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getuserID() {
		return userID;
	}
	public void setuserID(String userID) {
		this.userID = userID;
	}
	
}
