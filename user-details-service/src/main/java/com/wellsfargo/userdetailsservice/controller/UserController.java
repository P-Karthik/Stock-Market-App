package com.wellsfargo.userdetailsservice.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.wellsfargo.userdetailsservice.models.User;
import com.wellsfargo.userdetailsservice.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/users")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	@RequestMapping("/users/id/{id}")
	public User getUser(@PathVariable int id) {
		return userService.getUserDetails(id);
	}
	
	@RequestMapping("/users/{username}")
	public User getUserByUsername(@PathVariable String username) {
		return userService.getUserByUsername(username);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/users/add")
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/users/update")
	public void updateUser(@RequestBody User user) {
		userService.addUser(user);
	}
	
	@Transactional
	@RequestMapping(method=RequestMethod.DELETE,value="/users/delete/{username}")
	public void addUser(@PathVariable String username) {
		userService.deleteUserByUsername(username);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/authenticate")
	public boolean authenticate(@RequestBody List<String> l) {
		String username=l.get(0);
		String password=l.get(1);
		if(userService.authenticate(username, password).size()==1)
			return true;
		else
			return false;		
	}
	
}
