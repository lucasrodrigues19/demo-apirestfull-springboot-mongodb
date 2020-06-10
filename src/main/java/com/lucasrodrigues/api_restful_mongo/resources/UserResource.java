package com.lucasrodrigues.api_restful_mongo.resources;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lucasrodrigues.api_restful_mongo.domain.User;
import com.lucasrodrigues.api_restful_mongo.dto.UserDTO;
import com.lucasrodrigues.api_restful_mongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	private UserService service;

	@Autowired
	public UserResource(UserService service) {
	   this.service = service;
	}
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll() {
		
		List<User> list = service.findAll();
		List<UserDTO> listDTO = list.stream().map( x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

}
