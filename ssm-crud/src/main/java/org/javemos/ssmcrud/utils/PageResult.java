package org.javemos.ssmcrud.utils;

import java.util.List;

/**
 * @Description:
 */
public class PageResult {
	private long total;
	private long pages;
	private List rows;

	public PageResult(long total,long pages, List rows) {
		this.total = total;
		this.pages = pages;
		this.rows = rows;
	}

	public long getPages() {
		return pages;
	}

	public void setPages(long pages) {
		this.pages = pages;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}
}
