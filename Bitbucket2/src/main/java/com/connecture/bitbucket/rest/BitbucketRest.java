package com.connecture.bitbucket.rest;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.connecture.bitbucket.excel.MyExcelView;
import com.connecture.bitbucket.pullrequest.FinalData;
import com.connecture.bitbucket.pullrequest.PullRequestAPI;
import com.connecture.bitbucket.service.BitbucketServiceImpl;
import com.connecture.bitbucket.service.ExtractBitbucketAPIDataService;

@RestController
@RequestMapping(value = "/")
public class BitbucketRest {
	@Autowired
	private BitbucketServiceImpl bitbucketServiceImp;
	
	@Autowired
	private ExtractBitbucketAPIDataService extractBitbucketAPIDataService;


	@Value("${prefix.endPoint_pullrequests_activity}")
	private String pullrequests_activity_EndPoint;



	/**
	 * Endpoint for getting bitbucket activity responses based on request.
	 * 
	 * @return esb response
	 */

	@RequestMapping(value = "/commentsReport", method = RequestMethod.GET)
	public ModelAndView getMyData(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		Map<String, Object> model = new HashMap<String, Object>();
		String endPointURL = pullrequests_activity_EndPoint;
		List<FinalData> result = new ArrayList<>();
		Boolean isNextTrue = true;
		do {
			PullRequestAPI pullbitBucketAPI = bitbucketServiceImp.getPullRequestsActivity(endPointURL);
			List<FinalData> results =extractBitbucketAPIDataService. extractingDataFromBitBucketAPI(pullbitBucketAPI);
			result.addAll(results);

			if (pullbitBucketAPI.getNext() != null) {
				endPointURL = URLDecoder.decode(pullbitBucketAPI.getNext(), "UTF-8");
			} else {
				isNextTrue = false;
			}
		} while (isNextTrue);

		model.put("results", result);
		model.put("sheetname", "PullRequest.xls");
		List<String> headers = new ArrayList<String>();
		headers.add("TicketNumber");
		headers.add("PR_ID");
		headers.add("PR_State");
		headers.add("Author");
		headers.add("Comment");
		headers.add("Comment_Author");
		headers.add("Comment_Date");
		headers.add("Branch_Name");
		model.put("headers", headers);
		response.setContentType("application/ms-excel");
		response.setHeader("Content-disposition", "attachment; filename=PullrequestReport.xls");
		return new ModelAndView(new MyExcelView(), model);
	}
}
