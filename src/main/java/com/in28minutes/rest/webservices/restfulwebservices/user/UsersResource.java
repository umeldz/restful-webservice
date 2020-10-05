package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UsersResource {

	@Autowired
	private UserDaoService usersDao;

	@GetMapping(path = "/users")
	public List<User> retrieveAllUsers() {
		return usersDao.findAll();

	}

	@GetMapping(path = "/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		
		User user = usersDao.findOne(id);
		if(user == null) {
			throw new UserNotFoundException("id "+ id);
		}
		
		return user;
	}

	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = usersDao.save(user);

		URI location = ServletUriComponentsBuilder
									.fromCurrentRequest()
									.path("/{id}")
									.buildAndExpand(savedUser.getId()).toUri();

		return ResponseEntity.created(location).build();
	}

	@DeleteMapping(path = "/users/{id}")
	public void deleteUser(@PathVariable int id) {
		
		User user = usersDao.deleteById(id);
		if(user == null) {
			throw new UserNotFoundException("id "+ id);
		}
	}
}