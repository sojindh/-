package com.entity;

import java.util.ArrayList;

public class PageTO {
    ArrayList<BoardDTO> list ;
	int curPage ;
	int perPage = 5;
	int totalCount;
	ArrayList<BoardReplyDTO> Rlist;
	ArrayList<BoardFBDTO> Flist;
	ArrayList<BoardRTO> RSlist ;
	
	public ArrayList<BoardDTO> getList() {
		return list;
	}
	public void setList(ArrayList<BoardDTO> list) {
		this.list = list;
	}
	public ArrayList<BoardReplyDTO> getRList() {
		return Rlist;
	}
	public void setRList(ArrayList<BoardReplyDTO> Rlist) {
		this.Rlist = Rlist;
	}
	public ArrayList<BoardFBDTO> getFList() {
		return Flist;
	}
	public void setFList(ArrayList<BoardFBDTO> Flist) {
		this.Flist = Flist;
	}
	public ArrayList<BoardRTO> getRSList() {
		return RSlist;
	}
	public void setRSList(ArrayList<BoardRTO> RSlist) {
		this.RSlist = RSlist;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

}
