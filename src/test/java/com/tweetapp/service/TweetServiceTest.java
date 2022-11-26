package com.tweetapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.tweetapp.entity.Tweet;
import com.tweetapp.entity.User;
import com.tweetapp.repository.TweetRepository;
import com.tweetapp.repository.UserRepository;
import com.tweetapp.request.TweetRequest;

@ExtendWith(SpringExtension.class)
public class TweetServiceTest {

	@InjectMocks
	private TweetService tweetService;
	
	@Mock
	private UserRepository userRepository;
	
	@Mock
	private TweetRepository tweetRepository;
	
	@Test
	void testAddTweet() {
		TweetRequest tweetRequest=new TweetRequest("sham","sham");
		User user= new User();
		user.setEmailId("sham");
		user.setLoggedIn(true);
		when(userRepository.existsByEmailId("sham")).thenReturn(true);
		when(userRepository.findByEmailId("sham")).thenReturn(user);
		assertNotNull(tweetService.addTweet(tweetRequest));
		assertEquals("Tweet updated", tweetService.addTweet(tweetRequest));
	}
	
	@Test
	void testGetAllUsers() {
		User user= new User();
		user.setEmailId("sham");
		user.setLoggedIn(true);
		when(userRepository.existsByEmailId("sham")).thenReturn(true);
		when(userRepository.findByEmailId("sham")).thenReturn(user);
		assertNotNull(tweetService.getAllUsers("sham"));
	}
	
	@Test
	void testGetTweetsByUser() {
		User user= new User();
		user.setEmailId("sham");
		user.setLoggedIn(true);
		when(userRepository.existsByEmailId("sham")).thenReturn(true);
		when(userRepository.findByEmailId("sham")).thenReturn(user);
		assertNotNull(tweetService.getTweetsByUser("sham"));
	}
	
	@Test
	void testGetAllTweets() {
		User user= new User();
		user.setEmailId("sham");
		user.setLoggedIn(true);
		user.setPassword("sham");
		Tweet tweet=new Tweet();
		tweet.setEmail("sham");
		tweet.setTweet("hi");
		List<Tweet> tweetList=new ArrayList<>();
		tweetList.add(tweet);
		when(userRepository.existsByEmailId("sham")).thenReturn(true);
		when(userRepository.findByEmailId("sham")).thenReturn(user);
		when(tweetRepository.findAll()).thenReturn(tweetList);
		System.out.println(tweetList);
		assertNotNull(tweetService.getAllTweets("sham"));
	}
}
