package com.bookmanagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookmanagement.model.User;
import com.bookmanagement.model.UserDTO;
import com.bookmanagement.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userservice;
	
	@PostMapping("/register")
	public UserDTO register(@RequestBody User user) {
		return userservice.saveUser(user);
	}
	
}
