package org.javemos.ssmcrud.utils;

/**
 * @Description:
 */
public class QueryVo {
	private Integer page=1;
	private Integer size=5;
	private String custName;
	private String custSource;
	private String custIndustory;
	private String custLevel;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustSource() {
		return custSource;
	}

	public void setCustSource(String custSource) {
		this.custSource = custSource;
	}

	public String getCustIndustory() {
		return custIndustory;
	}

	public void setCustIndustory(String custIndustory) {
		this.custIndustory = custIndustory;
	}

	public String getCustLevel() {
		return custLevel;
	}

	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel;
	}

	@Override
	public String toString() {
		return "QueryVo{" +
				"page=" + page +
				", size=" + size +
				", custName='" + custName + '\'' +
				", custSource='" + custSource + '\'' +
				", custIndustory='" + custIndustory + '\'' +
				", custLevel='" + custLevel + '\'' +
				'}';
	}
}
