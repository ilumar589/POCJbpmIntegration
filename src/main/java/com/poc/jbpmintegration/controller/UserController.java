package com.poc.jbpmintegration.controller;

import com.poc.jbpmintegration.entity.User;
import com.poc.jbpmintegration.exception.ResourceNotFoundException;
import com.poc.jbpmintegration.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

	private final UserRepository userRepository;

	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@GetMapping("/users")
	public List<User> getAllNotes() {
		return userRepository.findAll();
	}

	@PostMapping("/users")
	public User createUser(@Valid @RequestBody User user) {
		return userRepository.save(user);
	}

	@GetMapping("/users/{id}")
	public User getNoteById(@PathVariable(value = "id") Long userId) {
		return userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
	}
}
