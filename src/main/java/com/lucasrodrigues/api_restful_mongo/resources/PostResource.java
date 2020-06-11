package com.lucasrodrigues.api_restful_mongo.resources;

import java.util.Date;
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
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
		text = URL.decodeParam(text);
		List<Post> posts = service.findByTitle(text);
		return ResponseEntity.ok().body(posts);
	}

	@RequestMapping(value = "/fullsearch", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> fullSearch( //
			@RequestParam(value = "text", defaultValue = "") String text, //
			@RequestParam(value = "minDate", defaultValue = "") String minDate, //
			@RequestParam(value = "maxDate", defaultValue = "") String maxDate //
	) {//

		Date dateMin = URL.convertDate(minDate, new Date(0L));
		Date dateMax = URL.convertDate(maxDate, new Date());
		text = URL.decodeParam(text);
		List<Post> posts = service.fullSearch(text, dateMin, dateMax);
		return ResponseEntity.ok().body(posts);
	}

}
