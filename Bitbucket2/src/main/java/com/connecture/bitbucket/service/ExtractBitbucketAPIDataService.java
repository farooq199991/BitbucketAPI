package com.connecture.bitbucket.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.connecture.bitbucket.pullrequest.FinalData;
import com.connecture.bitbucket.pullrequest.PullRequestAPI;
import com.connecture.bitbucket.pullrequest.PullrequestComments;
import com.connecture.bitbucket.pullrequest.UserCom;
import com.connecture.bitbucket.pullrequest.Values;
import com.connecture.bitbucket.pullrequest.ValuesComments;
import com.connecture.bitbucket.rest.BitbucketRest;
@Component
public class ExtractBitbucketAPIDataService {
	






	@Autowired
	private BitbucketServiceImpl bitbucketServiceImp;
	
	public  List<FinalData>  extractingDataFromBitBucketAPI(PullRequestAPI bitBucketAPI) {
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
							if (userCom.getDisplay_name().equalsIgnoreCase("Connecture BuildMaster")) {
								FinalData finaldata = new FinalData();

								finaldata.setTicketNumber(CommentesAndTicketNumberFilterService
										.ticketNumberFilter(values.getSource().getBranch().getName()));
								finaldata.setPr_id(values.getId());
								finaldata.setPr_state(values.getState());
								finaldata.setAuthor(values.getAuthor().getDisplay_name());
								finaldata.setComment(CommentesAndTicketNumberFilterService
										.commentFilter(valueComments.getContent().getRaw()));
								finaldata.setComment_Date(valueComments.getCreated_on());
								finaldata.setComment_Author(userCom.getDisplay_name());
								finaldata.setBranch_Name(values.getDestination().getBranch().getName());
								listFinaldata.add(finaldata);
							}

							else {
								FinalData finaldata = new FinalData();
								finaldata.setTicketNumber(CommentesAndTicketNumberFilterService
										.ticketNumberFilter(values.getSource().getBranch().getName()));
								finaldata.setPr_id(values.getId());
								finaldata.setPr_state(values.getState());
								finaldata.setAuthor(values.getAuthor().getDisplay_name());
								finaldata.setComment(CommentesAndTicketNumberFilterService
										.exclamationMarkFilter(valueComments.getContent().getRaw()));
								finaldata.setComment_Date(valueComments.getCreated_on());
								finaldata.setComment_Author(userCom.getDisplay_name());
								finaldata.setBranch_Name(values.getDestination().getBranch().getName());
								listFinaldata.add(finaldata);
							}
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

}
