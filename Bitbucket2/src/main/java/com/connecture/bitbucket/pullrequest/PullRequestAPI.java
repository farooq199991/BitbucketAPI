package com.connecture.bitbucket.pullrequest;


import java.util.List;

public class PullRequestAPI {
	private int pagelen;
	private int size;
	private int page;
	private List<Values> values;
	private String next;
	private String previous;

	public String getPrevious() {
		return previous;
	}

	public void setPrevious(String previous) {
		this.previous = previous;
	}

	public int getPagelen() {
		return pagelen;
	}

	public void setPagelen(int pagelen) {
		this.pagelen = pagelen;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public List<Values> getValues() {
		return values;
	}

	public void setValues(List<Values> values) {
		this.values = values;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

}
