package com.glabs.dmaic.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class UserController {

@Autowired
private UserRepository userRepository;

public UserRepository getRepository() {
	return userRepository;
}

public void setRepository(UserRepository repository) {
	this.userRepository = repository;
}

@GetMapping(value = "/users")
public List<User> getAllUsers() {
	return userRepository.findAll();
}

@PostMapping("/users")
User createOrSaveUser(@RequestBody User newUser) {
	return userRepository.save(newUser);
}

@GetMapping("/users/{id}")
	User getUserById(@PathVariable Long id) {
	return userRepository.findById(id).get();
}

@PutMapping("/users/{id}")
User updateUser(@RequestBody User newUser, @PathVariable Long id) {
	 
    return userRepository.findById(id).map(user -> {
        user.setFirstName(newUser.getFirstName());
        user.setLastName(newUser.getLastName());
        user.setPhoneNumber(newUser.getPhoneNumber());
        user.setEmail(newUser.getEmail());
        user.setPassword(newUser.getPassword());
        return userRepository.save(user);
    }).orElseGet(() -> {
        newUser.setId(id);
        return userRepository.save(newUser);
    });
}

@DeleteMapping("/users/{id}")
void deleteUser(@PathVariable Long id) {
	userRepository.deleteById(id);
}
}
