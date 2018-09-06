package com.connecture.bitbucket.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "prefix")
@Component
public class AppConfigProperties {

	private String username;
	private String password;
	private String endPoint_pullrequests_activity;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
	
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEndPoint_pullrequests_activity() {
		return endPoint_pullrequests_activity;
	}

	public void setEndPoint_pullrequests_activity(String endPoint_pullrequests_activity) {
		this.endPoint_pullrequests_activity = endPoint_pullrequests_activity;
	}

}
