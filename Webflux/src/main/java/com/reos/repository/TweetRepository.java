package com.reos.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.reos.model.Tweet;

@Repository
public interface TweetRepository extends ReactiveMongoRepository<Tweet, String>{

}
