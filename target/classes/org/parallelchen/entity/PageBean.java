package org.parallelchen.entity;

import java.util.List;

/**
 * ��װ��ҳ�Ĳ���
 * @author parallelchen
 *
 */
public class PageBean<T> {
	private int currentPage = 1 ; //��ǰҳ�棬Ĭ����ʾΪ1
	private int pageCount = 10  ; // ��ѯÿҳ��ʾ����������ѯ���ص���������Ĭ����ʾΪ10
	private int totalCount ; // �ܼ�¼��
	private int totalPage ; // ��ҳ��=�ܼ�¼��-ÿҳ������+1��  
	private List pageDate ; // ��ҳ��ѯ��������
	private int star ; //��ʼ����
	
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
	
	//������ҳ��
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
