package com.lucasrodrigues.api_restful_mongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.lucasrodrigues.api_restful_mongo.domain.User;
import com.lucasrodrigues.api_restful_mongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

private UserRepository repo;
	
	@Autowired
	public Instantiation(UserRepository repo) {
		this.repo = repo;
	}
	@Override
	public void run(String... args) throws Exception {
		repo.deleteAll();
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		repo.saveAll(Arrays.asList(maria,alex,bob));
	}

}
