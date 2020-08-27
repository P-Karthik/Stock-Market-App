package com.wellsfargo.userdetailsservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.wellsfargo.userdetailsservice.models.User;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepo;
	
	public void addUser(User u) {
		userRepo.save(u);
	}
	
	public List<User> getAllUsers(){
		List<User> users=new ArrayList<>();
		userRepo.findAll().forEach(users::add);
		return users;
	}
	
	public List<User> authenticate(String username,String password){
		return userRepo.findAllByUsernameAndPassword(username, password);
	}
	public User getUserDetails(int id) {
		return userRepo.findById(id).orElse(null);
	}
	
	public User getUserByUsername(String username) {
		return userRepo.findByUsername(username);
	}
	
	public void deleteUser(int id) {
		userRepo.deleteById(id);
	}
	
	public void deleteUserByUsername(String name) {
		userRepo.deleteByUsername(name);
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return getUserByUsername(username);

	}
}
