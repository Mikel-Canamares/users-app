package com.devs4.users.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devs4.users.models.User;
import com.devs4.users.services.UserServiceUsingList;


@RestController
//Definicion de mi recurso
@RequestMapping("v1//users")
public class UserControllerUsingList {
	
	@Autowired
	private UserServiceUsingList userService;
	
	
	@GetMapping
	//Metodo HTTP + Recurso -handler method
	public ResponseEntity<List<User>> getUsersRequest(@RequestParam(value = "startWith", required = false) String startWith){
		return new ResponseEntity<List<User>>(userService.getUsersRequest(startWith), HttpStatus.OK);
	}
	
//	@GetMapping
//	//Metodo HTTP + Recurso -handler method
//	public ResponseEntity<List<User>> getUsers(){
//		return new ResponseEntity<List<User>>(userService.getUsers(), HttpStatus.OK);
//	}
	
	@GetMapping(value = "/{username}")
	public ResponseEntity<User> getUserByUserName(@PathVariable("username") String username){
		return new ResponseEntity<User>(userService.getUserByUserName (username), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/{username}")
	public ResponseEntity<User> updateUser(@PathVariable("username") String username, @RequestBody User user){
		return new ResponseEntity<User>(userService.updateUser(user, username), HttpStatus.OK);
	}
	
	@DeleteMapping("/{username}")
	public ResponseEntity<Void> deleteUser(@PathVariable("username") String username){
		userService.deleteUser(username);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
