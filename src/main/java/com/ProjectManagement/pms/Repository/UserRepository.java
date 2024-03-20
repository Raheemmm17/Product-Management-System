package com.ProjectManagement.pms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ProjectManagement.pms.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
