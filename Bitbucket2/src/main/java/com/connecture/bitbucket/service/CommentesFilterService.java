package com.connecture.bitbucket.service;

public class CommentesFilterService {


	public static String commentFilter(String comment){
		
		String comment2 = comment.replaceAll("[\\(A-Za-z:/.-]*png\\)", "");
		String comment7 = comment2.replaceAll("\\[![\\[a-z\\]\\(:/.#_=%A-Za-z0-9\\)\\]]*", "");
		String comment4 = comment7.replaceAll("!", "").trim();
		
		return comment4;
	}
	
	public static String exclamationMarkFilter(String comment){
		
		String comment2=comment.replace("!", "").trim();
		
		return comment2;
	}
}
