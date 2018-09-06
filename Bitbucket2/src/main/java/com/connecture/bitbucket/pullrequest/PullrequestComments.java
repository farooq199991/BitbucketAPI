package com.connecture.bitbucket.pullrequest;

import java.net.URI;
import java.util.List;

public class PullrequestComments {
	private int pagelen;
	private int size;
	private List<ValuesComments> values;
	private int page;
	private String next;
	
	
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
	public List<ValuesComments> getValues() {
		return values;
	}
	public void setValues(List<ValuesComments> values) {
		this.values = values;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getNext() {
		return next;
	}
	public void setNext(String next) {
		this.next = next;
	}

}
