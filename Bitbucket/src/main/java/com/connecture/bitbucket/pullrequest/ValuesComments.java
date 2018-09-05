package com.connecture.bitbucket.pullrequest;

public class ValuesComments {
	private PullrequestCom pullrequest;
	private ContentCom content;
	private UserCom user;
	private String created_on;
	

	public PullrequestCom getPullrequest() {
		return pullrequest;
	}

	public void setPullrequest(PullrequestCom pullrequest) {
		this.pullrequest = pullrequest;
	}

	public ContentCom getContent() {
		return content;
	}

	public void setContent(ContentCom content) {
		this.content = content;
	}

	public UserCom getUser() {
		return user;
	}

	public void setUser(UserCom user) {
		this.user = user;
	}

	public String getCreated_on() {
		return created_on;
	}

	public void setCreated_on(String created_on) {
		this.created_on = created_on;
	}

}
