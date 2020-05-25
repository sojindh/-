package com.entity;

public class BoardDTO {

	int num;
	String userID;
	String author;
	String title;
	String major;
	String publisher;
	String price;
	String content;
	int readcnt;
	String writeday;

	public BoardDTO() {}
	public BoardDTO(int num, String author, String title, String major, String publisher, String price, String content,
			int readcnt, String writeday, String userID) {
		this.num = num;
		this.author = author;
		this.title = title;
		this.major = major;
		this.publisher = publisher;
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
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
	
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
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
