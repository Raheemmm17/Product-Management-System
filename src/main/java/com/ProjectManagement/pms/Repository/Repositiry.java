package com.ProjectManagement.pms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ProjectManagement.pms.model.Product;

@Repository
public interface Repositiry extends JpaRepository<Product, Integer>{

}
//xml dependecy injection is 2 type 1)constructor 2)setter
//how to create bean in 2 ways 1)annotation 2)xml tag
