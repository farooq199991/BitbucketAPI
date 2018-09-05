package com.connecture.bitbucket.pullrequest;

import java.util.List;

public class Commit {
	private String hash;
	private String type;
	private List<Links> links;
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<Links> getLinks() {
		return links;
	}
	public void setLinks(List<Links> links) {
		this.links = links;
	}
	
	

}
