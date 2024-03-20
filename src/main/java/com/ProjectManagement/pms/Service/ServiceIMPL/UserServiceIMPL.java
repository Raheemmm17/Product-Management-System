package com.ProjectManagement.pms.Service.ServiceIMPL;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ProjectManagement.pms.Repository.UserRepository;
import com.ProjectManagement.pms.Service.UserService;
import com.ProjectManagement.pms.model.User;
import com.ProjectManagement.pms.utility.ResponceStructure;

@Service
public class UserServiceIMPL implements UserService{

	private UserRepository repository;
	private ResponceStructure<User> structure;

	public UserServiceIMPL(UserRepository repository, ResponceStructure<User> structure) {
		super();
		this.repository = repository;
		this.structure = structure;
	}

	@Override
	public ResponseEntity<ResponceStructure<User>> saveUser(User user) {
		User saveUser = repository.save(user);
		return ResponseEntity.ok(structure.setStatusCOde(HttpStatus.OK.value())
				.setMessage("Data saved sucessfully")
				.setDate(saveUser));
	}

}
