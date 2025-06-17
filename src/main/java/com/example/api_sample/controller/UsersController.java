package com.example.api_sample.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.api_sample.entity.Users;
import com.example.api_sample.repository.UsersRepo;

@RestController
public class UsersController {
	@Autowired
	UsersRepo usersRepo;

	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/api/user")
	public ResponseEntity<Users> saveUser(@RequestBody Users users) {
		return new ResponseEntity<>(usersRepo.save(users), HttpStatus.CREATED);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/api/users")
	public ResponseEntity<List<Users>> getUsers() {
		return new ResponseEntity<>(usersRepo.findAll(), HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/api/user/{id}")
	public ResponseEntity<Users> getUser(@PathVariable long id) {
		Optional<Users> users = usersRepo.findById(id);
		if (users.isPresent()) {
			return new ResponseEntity<>(users.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/api/user/login")
	public ResponseEntity<Users> loginUser(@RequestBody Users loginRequest) {
		Optional<Users> user = usersRepo.findByUserEmailAndUserPassword(
				loginRequest.getUserEmail(), loginRequest.getUserPassword());
		if (user.isPresent()) {
			return new ResponseEntity<>(user.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED); // or NOT_FOUND
		}
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping("/api/user/{id}")
	public ResponseEntity<Users> updateUser(@PathVariable long id, @RequestBody Users user) {
		Optional<Users> users = usersRepo.findById(id);
		if (users.isPresent()) {
			users.get().setUserName(user.getUserName());
			users.get().setUserEmail(user.getUserEmail());
			users.get().setUserPassword(user.getUserPassword());
			return new ResponseEntity<>(usersRepo.save(users.get()), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("/api/user/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable long id) {
		Optional<Users> users = usersRepo.findById(id);
		if (users.isPresent()) {
			usersRepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
