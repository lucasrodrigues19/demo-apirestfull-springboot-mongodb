package com.lucasrodrigues.api_restful_mongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.lucasrodrigues.api_restful_mongo.domain.Post;
import com.lucasrodrigues.api_restful_mongo.domain.User;
import com.lucasrodrigues.api_restful_mongo.repository.PostRepository;
import com.lucasrodrigues.api_restful_mongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

private UserRepository userRepo;
private PostRepository postRepo;
	
	@Autowired
	public Instantiation(UserRepository userRepo,PostRepository postRepo) {
		this.userRepo = userRepo;
		this.postRepo = postRepo;
	}
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepo.deleteAll();
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		userRepo.saveAll(Arrays.asList(maria,alex,bob));
		
		
		postRepo.deleteAll();
		Post p1 = new Post(null,sdf.parse("21/03/2018"),"Partiu viagem","Vou viajar para São Paulo. Abraços!",maria);
		Post p2 = new Post(null,sdf.parse("23/03/2018"),"Bom dia","Acordei feliz hoje!",maria);
		postRepo.saveAll(Arrays.asList(p1,p2));
	}

}
