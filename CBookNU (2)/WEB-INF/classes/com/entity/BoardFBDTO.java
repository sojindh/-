package com.entity;

public class BoardFBDTO {

	int num;
	String userID;
	String title;
	String content;
	int readcnt;
	String writeday;
	
	public BoardFBDTO() {}
	public BoardFBDTO(int num, String userID, String title, String content, String writeday, int readcnt) {
		this.num = num;
		this.userID = userID;
		this.title = title;
		this.content = content;
		this.readcnt = readcnt;
		this.writeday = writeday;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public String getuserID() {
		return userID;
	}
	public void setuserID(String userID) {
		this.userID = userID;
	}
	
}
