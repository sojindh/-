package com.entity;

public class BoardReplyDTO {
	int id;
	int num;
	String content;
	String writeday;
	String userID;
	public BoardReplyDTO() {}
	
	public BoardReplyDTO(int id, int num, String userID, String content) {
		this.id = id;
		this.num = num;
		this.userID = userID;
		this.content = content;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getuserID() {
		return userID;
	}
	public void setuserID(String userID) {
		this.userID = userID;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriteday() {
		return writeday;
	}
	public void setWriteday(String writeday) {
		this.writeday = writeday;
	}
}
