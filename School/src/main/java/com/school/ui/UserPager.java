package com.school.ui;

public class UserPager {
	
	private int pageSize;//한 페이지당 데이터 개수
	private int pagerSize;//번호로 보여주는 페이지 Link 개수
	private Long dataCount;//총 데이터 수
	
	private int pageNo;//현재 페이지 번호
	private long pageCount;//총 페이지 수
	
	private String linkUrl;//페이저가 포함되는 페이지의 주소
	
	
	public UserPager(Long boardCount, int pageNo, int pageSize, int pagerSize, String linkUrl) {
		
		this.linkUrl = linkUrl;
		
		this.dataCount = boardCount;
		this.pageSize = pageSize;
		this.pagerSize = pagerSize;
		this.pageNo = pageNo;
		pageCount = 
			(boardCount / pageSize) + ((boardCount % pageSize) > 0 ? 1 : 0); 
	}
	
	public String toString(){
		StringBuffer linkString = new StringBuffer(2048);
		
		//1. 처음, 이전 항목 만들기
		if (pageNo > 1) {
			linkString.append(
				String.format("<a href='%s?pageNo=1'><<</a>",linkUrl));
			linkString.append("&nbsp;");
			linkString.append("&nbsp;");
			linkString.append(String.format(
				"<a href='%s?pageNo=%d'><</a>", linkUrl, pageNo - 1));
			linkString.append("&nbsp;");
		} else {
			linkString.append("<span style='color:lightgray'><<</span>");
			linkString.append("&nbsp;");
			linkString.append("&nbsp;");
			linkString.append("<span style='color:lightgray'><</span>");
			linkString.append("&nbsp;");
		}
		
		//2. 페이지 번호 Link 만들기
		int pagerBlock = (pageNo - 1) / pagerSize;
		int start = (pagerBlock * pagerSize) + 1;
		int end = start + pagerSize;
		for (int i = start; i < end; i++) {
			if (i > pageCount) break;
			linkString.append("&nbsp;");
			if(i == pageNo) {
				linkString.append(String.format("%d", i));
			} else { 
				linkString.append(String.format(
					"<a href='%s?pageNo=%d'>%d</a>", linkUrl, i, i));
			}
			linkString.append("&nbsp;");
		}
		
		//3. 다음, 마지막 항목 만들기
		if (pageNo < pageCount) {
			linkString.append("&nbsp;");
			linkString.append(String.format(
				"<a href='%s?pageNo=%d'>></a>",linkUrl, pageNo + 1));
			linkString.append("&nbsp;");
			linkString.append("&nbsp;");
			linkString.append(String.format(
				"<a href='%s?pageNo=%d'>>></a>", linkUrl, pageCount));
		} else {
			linkString.append("<span style='color:lightgray'>></span>");
			linkString.append("&nbsp;");
			linkString.append("&nbsp;");
			linkString.append("<span style='color:lightgray'>>></span>");
			linkString.append("&nbsp;");
		}
		
		return linkString.toString();
	}

}













