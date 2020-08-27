package com.wellsfargo.userdetailsservice.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.userdetailsservice.JwtUtil;
import com.wellsfargo.userdetailsservice.models.AuthenticationRequest;
import com.wellsfargo.userdetailsservice.models.AuthenticationResponse;
import com.wellsfargo.userdetailsservice.models.User;
import com.wellsfargo.userdetailsservice.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtUtil jwtTokenUtil;
	
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
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword())
					);
		}
		catch(BadCredentialsException e) {
			throw new Exception("Incorrect Username or Password",e);
		}
		final UserDetails userDetails= userService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt =jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt)); 
	}
	
}
