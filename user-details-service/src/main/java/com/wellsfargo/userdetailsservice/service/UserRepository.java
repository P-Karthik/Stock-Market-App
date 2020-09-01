package com.wellsfargo.userdetailsservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.wellsfargo.userdetailsservice.models.User;

public interface UserRepository extends CrudRepository<User,Integer>{
		Optional<User> findByUsername(String username);
		void deleteByUsername(String username);
		List<User> findAllByUsernameAndPassword(String username,String password);
}
