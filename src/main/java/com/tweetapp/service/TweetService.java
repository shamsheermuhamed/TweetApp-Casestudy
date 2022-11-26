package com.tweetapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweetapp.entity.Tweet;
import com.tweetapp.entity.User;
import com.tweetapp.exception.UserNotLoggedInException;
import com.tweetapp.repository.TweetRepository;
import com.tweetapp.repository.UserRepository;
import com.tweetapp.request.TweetRequest;

@Service
public class TweetService {

	@Autowired
	TweetRepository tweetRepository;
	
	@Autowired
	UserRepository userRepository;

	public List<String> getAllUsers(String emailId) {

		if(userRepository.findByEmailId(emailId)!=null && userRepository.findByEmailId(emailId).isLoggedIn()) {
			return userRepository.findAll().stream().map(User::getName)
					.collect(Collectors.toList());
		}
		else {
			throw new UserNotLoggedInException();
		}
	}

	public String addTweet(TweetRequest tweetRequest) {
		
		if(userRepository.existsByEmailId(tweetRequest.getEmail()) &&
				userRepository.findByEmailId(tweetRequest.getEmail()).isLoggedIn()) {
			
			Tweet tweet=new Tweet();
			tweet.setEmail(tweetRequest.getEmail());
			tweet.setTweet(tweetRequest.getTweet());
			tweetRepository.save(tweet);
			return "Tweet updated";
		}
		else {
			throw new UserNotLoggedInException();
		}
	}

	public List<String> getTweetsByUser(String emailId) {
		if(userRepository.existsByEmailId(emailId) &&
				userRepository.findByEmailId(emailId).isLoggedIn()) {
			
			return tweetRepository.findByEmail(emailId).stream().map(Tweet::getTweet)
					.collect(Collectors.toList());
		}
		else {
			throw new UserNotLoggedInException();
		}
	}

	public List<Tweet> getAllTweets(String emailId) {
		if(userRepository.existsByEmailId(emailId) &&
				userRepository.findByEmailId(emailId).isLoggedIn()) {
			return tweetRepository.findAll();
		}
		else {
			throw new UserNotLoggedInException();
		}
	}
	
	
}
