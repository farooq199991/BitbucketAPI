package com.connecture.bitbucket.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommentesAndTicketNumberFilterService {

	public static String commentFilter(String comment) {

		String comment2 = comment.replaceAll("[\\(A-Za-z:/.-]*png\\)", "");
		String comment7 = comment2.replaceAll("\\[![\\[a-z\\]\\(:/.#_=%A-Za-z0-9\\)\\]]*", "");
		String comment4 = comment7.replaceAll("!", "").trim();

		return comment4;
	}

	public static String exclamationMarkFilter(String comment) {

		String comment2 = comment.replace("!", "").trim();

		return comment2;
	}

	/*
	 * Filtering ticket Number
	 */

	public static String ticketNumberFilter(String ticketNumber) {
		String filteredTicketNumber = "";
		if (ticketNumber.contains("UHGP") || ticketNumber.contains("uhgp")) {

			Pattern p1 = Pattern.compile("([UHGPuhgp]*)[-][0-9]{2,6}");
			Matcher m1 = p1.matcher(ticketNumber);
			if (m1.find()) {
				filteredTicketNumber = m1.group();

			}
			return filteredTicketNumber;
		} else if (ticketNumber.contains("SHSUH") || ticketNumber.contains("shsuh")) {

			Pattern p1 = Pattern.compile("([SHSUHshsuh]*)[-][0-9]{2,6}");
			Matcher m1 = p1.matcher(ticketNumber);
			if (m1.find()) {
				filteredTicketNumber = m1.group();

			}
			return filteredTicketNumber;

		} else {
			return ticketNumber;
		}

	}
}
