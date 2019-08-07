package com.poc.jbpmintegration.controller;

import com.poc.jbpmintegration.converter.UserCategoryConverter;
import com.poc.jbpmintegration.entity.User;
import com.poc.jbpmintegration.entity.UserCategory;
import com.poc.jbpmintegration.service.UserService;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@InitBinder
	public void initBinder(final WebDataBinder webdataBinder) {
		webdataBinder.registerCustomEditor(UserCategory.class, new UserCategoryConverter());
	}

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.findAll();
	}

	@PostMapping("/users/{role}")
	public User createUser(@Valid @RequestBody User user, @PathVariable(value = "role") UserCategory role) {
		return userService.save(user, role);
	}

	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable(value = "id") Long userId) {
		return userService.findById(userId);
	}

	@GetMapping("/users/email/{email:.+}")
	public User getUserByEmail(@PathVariable(value = "email") String email) {
		return userService.findUserByEmail(email);
	}
}
