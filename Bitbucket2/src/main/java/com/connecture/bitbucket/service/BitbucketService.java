package com.connecture.bitbucket.service;


import java.net.URI;


import com.connecture.bitbucket.pullrequest.PullRequestAPI;
import com.connecture.bitbucket.pullrequest.PullrequestComments;

public interface BitbucketService {
	public void initialize();
    
	public PullrequestComments getPullRequests(String u);
	
	public PullRequestAPI getPullRequestsActivity(String endPoint);

}
