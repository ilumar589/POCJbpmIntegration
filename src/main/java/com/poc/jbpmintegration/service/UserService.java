package com.poc.jbpmintegration.service;

import com.poc.jbpmintegration.entity.Role;
import com.poc.jbpmintegration.entity.User;
import com.poc.jbpmintegration.entity.UserCategory;
import com.poc.jbpmintegration.exception.ResourceNotFoundException;
import com.poc.jbpmintegration.repository.RoleRepository;
import com.poc.jbpmintegration.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public UserService(UserRepository userRepository,
	                   RoleRepository roleRepository,
	                   BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	public List<User> findAll() { return userRepository.findAll(); }

	public User findById(Long id) { return  userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id)); }

	public User findUserByEmail(String email) {
		return Optional.of(userRepository.findByEmail(email)).orElseThrow(() -> new ResourceNotFoundException("User", "email", email));
	}

	public User save(User user, UserCategory role) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(1);
		Role userRole = roleRepository.findByRole(role.toString());
		user.setRoles(new HashSet<>(Collections.singletonList(userRole)));
		return userRepository.save(user);
	}
}
