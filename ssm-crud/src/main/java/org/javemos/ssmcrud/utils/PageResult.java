package org.javemos.ssmcrud.utils;

import java.util.List;

/**
 * @Description:
 */
public class PageResult {
	private Long total;
	private Integer pages;
	private Integer size;
	private List rows;

	public PageResult(Long total, Integer pages, Integer size, List rows) {
		this.total = total;
		this.pages = pages;
		this.size = size;
		this.rows = rows;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}
}
