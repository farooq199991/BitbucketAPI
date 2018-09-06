package com.connecture.bitbucket.pullrequest;

public class CommentsList {
	private String comment;
	private String Comment_date;
	private String Comment_author;
	private int Pr_id;
	
	

	public int getPr_id() {
		return Pr_id;
	}

	public void setPr_id(int pr_id) {
		Pr_id = pr_id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getComment_date() {
		return Comment_date;
	}

	public void setComment_date(String comment_date) {
		Comment_date = comment_date;
	}

	public String getComment_author() {
		return Comment_author;
	}

	public void setComment_author(String comment_author) {
		Comment_author = comment_author;
	}

}
