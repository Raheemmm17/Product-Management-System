package com.ProjectManagement.pms.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ProjectManagement.pms.Service.UserService;
import com.ProjectManagement.pms.model.User;
import com.ProjectManagement.pms.utility.ResponceStructure;

@RestController
public class UserController {
	private UserService service;
	
	public UserController(UserService service) {
		super();
		this.service = service;
	}
	@PostMapping("/users")
	public ResponseEntity<ResponceStructure<User>> saveUser(@RequestBody User user){
		return service.saveUser(user);
	}
}
