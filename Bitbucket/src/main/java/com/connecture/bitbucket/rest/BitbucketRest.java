package com.connecture.bitbucket.rest;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.connecture.bitbucket.excel.MyExcelView;
import com.connecture.bitbucket.pullrequest.FinalData;
import com.connecture.bitbucket.pullrequest.PullRequestAPI;
import com.connecture.bitbucket.pullrequest.PullrequestComments;
import com.connecture.bitbucket.pullrequest.UserCom;
import com.connecture.bitbucket.pullrequest.Values;
import com.connecture.bitbucket.pullrequest.ValuesComments;
import com.connecture.bitbucket.service.BitbucketServiceImpl;

@RestController
@RequestMapping(value = "/")
public class BitbucketRest {
	@Autowired
	private BitbucketServiceImpl bitbucketServiceImp;

	@Value("${prefix.endPoint_pullrequests_activity}")
	private String pullrequests_activity_EndPoint;

	private static String SONAR_DEFAULT_COMMENT = "**SonarQube Analysis**";

	/**
	 * Endpoint for getting bitbucket activity responses based on request.
	 * 
	 * @return esb response
	 */

	public List<FinalData> extracingDataFromBitBucketAPI(PullRequestAPI bitBucketAPI) {
		List<FinalData> listFinaldata = new ArrayList<FinalData>();

		List<Values> value = bitBucketAPI.getValues();
		for (Values values : value) {

			String commentEndPointURL = values.getLinks().getComments().getHref();
			Boolean isNextTrue = true;
			do {
				PullrequestComments pullrequestComments = bitbucketServiceImp.getPullRequests(commentEndPointURL);
				List<ValuesComments> valueCommentList = pullrequestComments.getValues();
				for (ValuesComments valueComments : valueCommentList) {

					{
						UserCom userCom = valueComments.getUser();
						
						if (userCom != null) {
							FinalData finaldata = new FinalData();
							finaldata.setPr_id(values.getId());
							finaldata.setPr_state(values.getState());
							finaldata.setAuthor(values.getAuthor().getDisplay_name());
							finaldata.setComment(valueComments.getContent().getRaw());
							finaldata.setComment_Date(valueComments.getCreated_on());
							finaldata.setComment_Author(userCom.getDisplay_name());
							finaldata.setBranch_Name(values.getDestination().getBranch().getName());
							listFinaldata.add(finaldata);
						}
					}

				}

				if (pullrequestComments.getNext() != null) {
					commentEndPointURL = pullrequestComments.getNext();
				} else {
					isNextTrue = false;
				}
			} while (isNextTrue);

		}
		return listFinaldata;
	}

	@RequestMapping(value = "/commentsReport", method = RequestMethod.GET)
	public ModelAndView getMyData(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		Map<String, Object> model = new HashMap<String, Object>();
		String endPointURL = pullrequests_activity_EndPoint;
		List<FinalData> result = new ArrayList<>();
		Boolean isNextTrue = true;
		do {
			PullRequestAPI pullbitBucketAPI = bitbucketServiceImp.getPullRequestsActivity(endPointURL);
			List<FinalData> results = extracingDataFromBitBucketAPI(pullbitBucketAPI);
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
