package com.lucasrodrigues.api_restful_mongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasrodrigues.api_restful_mongo.domain.User;
import com.lucasrodrigues.api_restful_mongo.dto.UserDTO;
import com.lucasrodrigues.api_restful_mongo.repository.UserRepository;

@Service
public class UserService {

	private UserRepository repo;

	@Autowired
	public UserService(UserRepository repo) {
		this.repo = repo;
	}

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public User insert(User obj) {
		return repo.insert(obj);
	}
	public User fromDTO(UserDTO obj) {
		return new User(obj.getId(),obj.getName(),obj.getEmail());
	}

	public void delete(String id) {
		repo.deleteById(id);
		
	}
	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
		}

	private void updateData(User newObj, User obj) {
		newObj.setEmail(obj.getEmail());
		newObj.setName(obj.getName());
		
	}
}
