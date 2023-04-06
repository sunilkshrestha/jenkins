package com.udemy.microservices.mobileapp.ws.ui.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import com.udemy.microservices.mobileapp.ws.model.User;
import com.udemy.microservices.mobileapp.ws.request.UserDetailRequest;

@RestController
@RequestMapping("users")
public class UserController {
	
	@GetMapping
	public String getUsers(@RequestParam(name="page" , required=false) @Nullable Integer page,
			@RequestParam(name="limit") int limit) {
		return String.format("getUsers was called page=%d, limit=%d", page, limit);
	}
	
	@GetMapping(path="/{userId}", 
			produces= {
				MediaType.APPLICATION_JSON_VALUE, 
				MediaType.APPLICATION_XML_VALUE
			}
	)
	public ResponseEntity<User> getUser(@PathVariable(name="userId") String userId) {
		User user = new User();
		user.setUsername("sunil");
		user.setPassword("shrestha");
		user.setEmail("ss@gmail.com");
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@PostMapping(
			consumes= {
					MediaType.APPLICATION_JSON_VALUE, 
					MediaType.APPLICATION_XML_VALUE
				}
			,produces= {
			MediaType.APPLICATION_JSON_VALUE, 
			MediaType.APPLICATION_XML_VALUE
		})
	public ResponseEntity<User> createUser(@Valid @RequestBody UserDetailRequest userDetailRequest ) {
		User user = new User();
		user.setUsername(userDetailRequest.getUsername());
		user.setPassword(userDetailRequest.getPassword());
		user.setEmail(userDetailRequest.getEmail());
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	@PutMapping
	public String updateUser() {
		return "updateUser was called";
	}
	
	@DeleteMapping("/userId")
	public String deleteUser(@RequestParam String uid) {
		
		return "deleteUser was called " +uid;
	}
	
}
