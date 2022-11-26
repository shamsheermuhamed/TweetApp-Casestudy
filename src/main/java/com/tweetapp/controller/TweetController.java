package com.tweetapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tweetapp.entity.Tweet;
import com.tweetapp.request.TweetRequest;
import com.tweetapp.service.TweetService;

@RestController
public class TweetController {
	
	@Autowired
	TweetService tweetService;
	
	@GetMapping("/alltweets/{emailId}")
	List<Tweet> getAllTweets(@PathVariable String emailId){
		return tweetService.getAllTweets(emailId);
	}
	
	@GetMapping("/tweetsbyuser/{emailId}")
	List<String> getTweetsByUser(@PathVariable String emailId){
		return tweetService.getTweetsByUser(emailId);
	}
	
	@GetMapping("/allusers/{emailId}")
	List<String> getAllUsers(@PathVariable String emailId){
		return tweetService.getAllUsers(emailId);
	}
	
	@PostMapping("/tweet")
	String addTweet(@RequestBody TweetRequest tweetRequest) {
		return tweetService.addTweet(tweetRequest);
	}
	
	
}
