package com.connecture.bitbucket.pullrequest;

import java.util.List;

public class Source {
	private List<Commit> commit;
	private List<Repository> repository;
	private Branch branch;
	public List<Commit> getCommit() {
		return commit;
	}
	public void setCommit(List<Commit> commit) {
		this.commit = commit;
	}
	public List<Repository> getRepository() {
		return repository;
	}
	public void setRepository(List<Repository> repository) {
		this.repository = repository;
	}
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	
	

}
