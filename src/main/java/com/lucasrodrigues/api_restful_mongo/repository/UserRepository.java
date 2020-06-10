package com.lucasrodrigues.api_restful_mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lucasrodrigues.api_restful_mongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

	
}
