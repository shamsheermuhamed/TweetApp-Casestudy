package com.tweetapp.request;

public class TweetRequest {

	String email;
	String tweet;
	
	public TweetRequest(String email, String tweet) {
		this.email = email;
		this.tweet = tweet;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTweet() {
		return tweet;
	}
	public void setTweet(String tweet) {
		this.tweet = tweet;
	}
	
	
}
