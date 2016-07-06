package org.joyiism.domain;

public class PageMaker {
	private int pageNo;
	private int size;
	private int totalCount;
	private int lastPage;
	private int currentTab;
	private int startPage;
	private int endPage;
	private String searchType;
	private String searchKeyword;
	
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	public int getCurrentTab() {
		return currentTab;
	}
	public void setCurrentTab(int currentTab) {
		this.currentTab = currentTab;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	
	@Override
	public String toString() {
		return "PageMaker [pageNo=" + pageNo + ", size=" + size + ", totalCount=" + totalCount + ", lastPage="
				+ lastPage + ", currentTab=" + currentTab + ", startPage=" + startPage + ", endPage=" + endPage
				+ ", searchType=" + searchType + ", searchKeyword=" + searchKeyword + "]";
	}
}
