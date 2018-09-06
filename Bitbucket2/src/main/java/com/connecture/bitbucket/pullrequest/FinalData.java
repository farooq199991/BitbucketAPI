package com.connecture.bitbucket.pullrequest;

/**
 * @author mohammadm
 *
 */
public class FinalData {
	private String ticketNumber;
	private int pr_id;
	private String pr_state;
	private String Author;
	private String comment;
	private String comment_Date;
	private String comment_Author;
	private String branch_Name;
	
	
	
	public String getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	public int getPr_id() {
		return pr_id;
	}
	public void setPr_id(int pr_id) {
		this.pr_id = pr_id;
	}
	public String getPr_state() {
		return pr_state;
	}
	public void setPr_state(String pr_state) {
		this.pr_state = pr_state;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getComment_Date() {
		return comment_Date;
	}
	public void setComment_Date(String comment_Date) {
		this.comment_Date = comment_Date;
	}
	public String getComment_Author() {
		return comment_Author;
	}
	public void setComment_Author(String comment_Author) {
		this.comment_Author = comment_Author;
	}
	public String getBranch_Name() {
		return branch_Name;
	}
	public void setBranch_Name(String branch_Name) {
		this.branch_Name = branch_Name;
	}

	
	
	

}
