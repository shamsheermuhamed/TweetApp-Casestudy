package com.tweetapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tweetapp.entity.Tweet;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Integer> {

	List<Tweet> findByEmail(String emailId);

}
