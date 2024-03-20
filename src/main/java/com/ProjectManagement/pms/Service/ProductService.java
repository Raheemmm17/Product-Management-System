package com.ProjectManagement.pms.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ProjectManagement.pms.dto.ProductRequest;
import com.ProjectManagement.pms.model.Product;
import com.ProjectManagement.pms.utility.ResponceStructure;

public interface ProductService {
	public ResponseEntity<ResponceStructure<Product>> saveProduct(ProductRequest productRequest);

	public ResponseEntity<ResponceStructure<List<Product>>> findAll();

	public ResponseEntity<ResponceStructure<Product>> findByActorId(int actorId);

	public ResponseEntity<ResponceStructure<Product>> deleteById(int actorId);

	public ResponseEntity<ResponceStructure<Product>> updateById(int productId, Product product);

}