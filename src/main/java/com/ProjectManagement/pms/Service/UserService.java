package com.ProjectManagement.pms.Service;

import org.springframework.http.ResponseEntity;

import com.ProjectManagement.pms.model.User;
import com.ProjectManagement.pms.utility.ResponceStructure;

public interface UserService {
	public ResponseEntity<ResponceStructure<User>> saveUser(User user);

}
