package com.tweetapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweetapp.entity.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Integer> {

	List<Tweet> findByEmail(String emailId);

}
