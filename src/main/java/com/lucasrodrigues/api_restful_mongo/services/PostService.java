package com.lucasrodrigues.api_restful_mongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasrodrigues.api_restful_mongo.domain.Post;
import com.lucasrodrigues.api_restful_mongo.repository.PostRepository;

@Service
public class PostService {

	private PostRepository repo;

	@Autowired
	public PostService(PostRepository repo) {
		this.repo = repo;
	}

	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public List<Post> findByTitle(String text){
		return repo.searchTitle(text);
	}
	
}
