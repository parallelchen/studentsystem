package org.parallelchen.entity;

import java.util.List;

/**
 * 封装分页的参数
 * @author parallelchen
 *
 */
public class PageBean<T> {
	private int currentPage = 1 ; //当前页面，默认显示为1
	private int pageCount = 10  ; // 查询每页显示的行数（查询返回的行数），默认显示为10
	private int totalCount ; // 总记录数
	private int totalPage ; // 总页数=总记录数-每页行数（+1）  
	private List pageDate ; // 分页查询到的数据
	private int star ; //开始数据
	
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	//返回总页数
	public int getToalPage() {
		if(totalCount % pageCount == 0) {
			totalPage = totalCount / pageCount ;
		}else {
			totalPage = totalCount / pageCount+1 ;
		}
		return totalPage ;
	}
	
	
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	public List getPageDate() {
		return pageDate;
	}
	public void setPageDate(List pageDate) {
		this.pageDate = pageDate;
	}
	
	

}
