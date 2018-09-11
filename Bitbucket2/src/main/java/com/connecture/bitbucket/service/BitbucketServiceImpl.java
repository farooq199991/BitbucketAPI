package com.connecture.bitbucket.service;

import java.io.IOException;

import java.util.Map;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.connecture.bitbucket.pullrequest.PullRequestAPI;
import com.connecture.bitbucket.pullrequest.PullrequestComments;
import com.connecture.bitbucket.service.BitbucketService;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Decoder.BASE64Encoder;

@Service
public class BitbucketServiceImpl implements BitbucketService {

	private Logger logger = LoggerFactory.getLogger(BitbucketServiceImpl.class);

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ObjectMapper mapper;

	@Value("${prefix.username}")
	private String username;

	@Value("${prefix.password}")
	private String password;
	

	@Value("${prefix.endPoint_pullrequests_activity}")
	private String pullrequests_activity_EndPoint;


	public void initialize() {
		// To write later
	}

	@SuppressWarnings("rawtypes")
	@Override
	public PullRequestAPI getPullRequestsActivity(String endPoint) {
		PullRequestAPI result = null;
		try {
			ResponseEntity<Map> responseEntity = restTemplate.exchange(endPoint, HttpMethod.GET,
					getHttpEntity(), Map.class);

			mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
			mapper.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true);
			result = mapper.readValue(new JSONObject((Map) responseEntity.getBody()).toJSONString(),
					PullRequestAPI.class);
			
			//Filter unwanted data using REGEX TODO

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return result;

	}
	
	@Override
	public PullrequestComments getPullRequests(String commentsEndPoint) {
		PullrequestComments result1 = null;
		try {
			ResponseEntity<Map> responseEntity = restTemplate.exchange(u, HttpMethod.GET, getHttpEntity(), Map.class);

			mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
			mapper.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true);
			result1 = mapper.readValue(new JSONObject((Map) responseEntity.getBody()).toJSONString(),
					PullrequestComments.class);

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return result1;
	}


	public HttpEntity<String> getHttpEntity() throws IOException, JsonGenerationException, JsonMappingException {
		String auth = username + ":" + password;
		String authHeader = new BASE64Encoder().encode(auth.getBytes());
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + authHeader);
		return new HttpEntity<String>(headers);
	}

	

}
