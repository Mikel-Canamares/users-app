package com.devs4.users.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.devs4.users.models.User;
import com.github.javafaker.Faker;

@Service
public class UserServiceUsingList {
	
	@Autowired
	private Faker faker;

	
	private List<User> users = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		for(int i = 0; i <100; i++) {
			users.add(new User(faker.funnyName().name(),faker.name().username() ,faker.dragonBall().character()));
		}
	}
	
	public List<User> getUsersRequest(String startWith) {
		if(startWith!=null) {
			return users.stream().filter(u -> u.getUserName().startsWith(startWith)).collect(Collectors.toList());
		}else {
			return users;
		}
		
	}

//	public List<User> getUsers() {
//		return users;
//	}
	
	//Uso de lambdas
	public User getUserByUserName(String username) {
		return users.stream().filter(u -> u.getUserName().equals(username)).findAny().orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND , String.format("user %s not found", username)));
	}
	
	public User createUser(User user) {
		if(users.stream().anyMatch(u -> u.getUserName().equals(user.getUserName()))) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, 
					String.format("User %s already exist", user.getUserName()));
		}
		users.add(user);
		return user;
	}
	
	public User updateUser(User user, String username) {
	 User userToBeUpdated =	getUserByUserName(username);
	 userToBeUpdated.setNickName(user.getNickName());
	 userToBeUpdated.setPassword(user.getPassword());
	 return userToBeUpdated;
	}
	
	public void deleteUser(String userName) {
		User userByUserName = getUserByUserName(userName);
		users.remove(userByUserName);
	}
	
	
	
}
