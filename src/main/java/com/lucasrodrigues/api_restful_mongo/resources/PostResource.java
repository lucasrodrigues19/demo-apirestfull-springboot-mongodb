package com.lucasrodrigues.api_restful_mongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lucasrodrigues.api_restful_mongo.domain.Post;
import com.lucasrodrigues.api_restful_mongo.resources.util.URL;
import com.lucasrodrigues.api_restful_mongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	private PostService service;

	@Autowired
	public PostResource(PostService service) {
		this.service = service;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post post = service.findById(id);
		return ResponseEntity.ok().body(post);
	}
	
	@RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue="") String text) {
		text = URL.decodeParam(text);
		List<Post> posts = service.findByTitle(text);
		return ResponseEntity.ok().body(posts);
	}

}
