package com.connecture.bitbucket.pullrequest;

import java.util.List;

public class Values {
	
	private String description;
	private Links links;
	private String title;
	private Boolean close_source_branch;
	private String type;
	private int id;
	private Destination destination;
	private String created_on;
	private List<Summary> summary;
	private List<Source> source;
	private int comment_count;
	private String state;
	private int task_count;
	private String reason;
	private String updated_on;
	private Author author;
	private List<MergeCommit> merge_commit;
	private List<ClosedBy> closed_by;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Links getLinks() {
		return links;
	}
	public void setLinks(Links links) {
		this.links = links;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Boolean getClose_source_branch() {
		return close_source_branch;
	}
	public void setClose_source_branch(Boolean close_source_branch) {
		this.close_source_branch = close_source_branch;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Destination getDestination() {
		return destination;
	}
	public void setDestination(Destination destination) {
		this.destination = destination;
	}
	public String getCreated_on() {
		return created_on;
	}
	public void setCreated_on(String created_on) {
		this.created_on = created_on;
	}
	public List<Summary> getSummary() {
		return summary;
	}
	public void setSummary(List<Summary> summary) {
		this.summary = summary;
	}
	public List<Source> getSource() {
		return source;
	}
	public void setSource(List<Source> source) {
		this.source = source;
	}
	public int getComment_count() {
		return comment_count;
	}
	public void setComment_count(int comment_count) {
		this.comment_count = comment_count;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getTask_count() {
		return task_count;
	}
	public void setTask_count(int task_count) {
		this.task_count = task_count;
	}
	
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getUpdated_on() {
		return updated_on;
	}
	public void setUpdated_on(String updated_on) {
		this.updated_on = updated_on;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public List<MergeCommit> getMerge_commit() {
		return merge_commit;
	}
	public void setMerge_commit(List<MergeCommit> merge_commit) {
		this.merge_commit = merge_commit;
	}
	public List<ClosedBy> getClosed_by() {
		return closed_by;
	}
	public void setClosed_by(List<ClosedBy> closed_by) {
		this.closed_by = closed_by;
	}



	

	

}
