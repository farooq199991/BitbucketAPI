package com.connecture.bitbucket.pullrequest;

import java.util.List;

public class MergeCommit {
	private String hash;
	private String Type;
	private List<Links> links;
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public List<Links> getLinks() {
		return links;
	}
	public void setLinks(List<Links> links) {
		this.links = links;
	}
	
	

}
