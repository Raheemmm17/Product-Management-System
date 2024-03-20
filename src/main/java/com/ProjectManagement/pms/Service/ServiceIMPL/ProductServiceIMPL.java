package com.ProjectManagement.pms.Service.ServiceIMPL;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ProjectManagement.pms.Exception.ProductNotFoundById;
import com.ProjectManagement.pms.Repository.Repositiry;
import com.ProjectManagement.pms.Service.ProductService;
import com.ProjectManagement.pms.dto.ProductRequest;
import com.ProjectManagement.pms.model.Product;
import com.ProjectManagement.pms.utility.ResponceStructure;

@Service
public class ProductServiceIMPL implements ProductService{

	private Repositiry repository;
	private ResponceStructure<Product> structure;
	private ResponceStructure<List<Product>> structureList;


	public ProductServiceIMPL(Repositiry repository, ResponceStructure<Product> structure,
			ResponceStructure<List<Product>> structureList) {
		super();
		this.repository = repository;
		this.structure = structure;
		this.structureList = structureList;
	}

	@Override
	public ResponseEntity<ResponceStructure<List<Product>>> findAll() {
		List<Product> products = repository.findAll();
		if(!products.isEmpty()) {
			return ResponseEntity.ok(
					structureList.setStatusCOde(HttpStatus.OK.value())
					.setMessage("Deleted done")
					.setDate(products));
		}else throw new RuntimeException();
	}

	@Override
	public ResponseEntity<ResponceStructure<Product>> findByActorId(int productId) {
		return repository.findById(productId).map(p->{
			return ResponseEntity.ok(structure.setStatusCOde(HttpStatus.OK.value())
					.setMessage("Product found!!")
					.setDate(p));})
				.orElseThrow(()-> new ProductNotFoundById("Product not found by ID"));
	}

	@Override
	public ResponseEntity<ResponceStructure<Product>> deleteById(int productId) {

		return repository.findById(productId).map(p->{ResponceStructure<Product> s = new ResponceStructure<Product>();
		return ResponseEntity.ok(s.setStatusCOde(HttpStatus.OK.value())
				.setMessage("Deleted done")
				.setDate(p));}).orElseThrow(()-> new RuntimeException());
	}


	@Override
	public ResponseEntity<ResponceStructure<Product>> updateById(int productId, Product product) {
		return repository.findById(productId).map(exProduct->{
			product.setProductId(exProduct.getProductId());
			exProduct = repository.save(product);
			return ResponseEntity.ok(structure.setStatusCOde(HttpStatus.OK.value())
					.setMessage("Its done")
					.setDate(exProduct));			
		}).orElseThrow(()->new RuntimeException());
	}

	@Override
	public ResponseEntity<ResponceStructure<Product>> saveProduct(ProductRequest productRequest) {
		//y new product? in save we are dealing with new object and in update we are dealing with exsiting object
		Product product = repository.save(mapToProduct(productRequest, new Product()));
		return ResponseEntity.ok(structure.setStatusCOde(HttpStatus.OK.value())
				.setMessage("Data Saved done")
				.setDate(product));
	}

	//Y new method? because update and save done bye here
	private Product mapToProduct(ProductRequest productRequest, Product product) {
		product.setProductName(productRequest.getProductName());
		return product;
	}
}
//Optional<Product> optional = repository.findById(productId);
//if(optional.isPresent()) {
//	Product existingproduct = optional.get();
//	repository.deleteById(productId);
//	ResponceStructure<Product> responseStructure = new ResponceStructure<>();
//	responseStructure.setStatusCOde(HttpStatus.ACCEPTED.value());
//	responseStructure.setMessage("Actor Object created successfully");
//	responseStructure.setDate(existingproduct);
//	return new ResponseEntity<ResponceStructure<Product>>(responseStructure, HttpStatus.OK);

//List<Product> list = repository.findAll();
//if(list!=null) { 
//	ResponceStructure<List<Product>> responseStructure = new ResponceStructure<>();
//	responseStructure.setStatusCOde(HttpStatus.ACCEPTED.value());
//	responseStructure.setMessage("Actor Object created successfully");
//	responseStructure.setDate(list);
//	return new ResponseEntity<ResponceStructure<List<Product>>>(responseStructure, HttpStatus.OK);

//Product products = repository.save(product);
//ResponceStructure<Product> responseEntity = new ResponceStructure<Product>();
//responseEntity.setStatusCOde(HttpStatus.ACCEPTED.value());
//responseEntity.setMessage("Saved Successfully");
//responseEntity.setDate(products);
//return new ResponseEntity<ResponceStructure<Product>>(responseEntity,HttpStatus.ACCEPTED);

//public ResponseEntity<ResponceStructure<Product>> findByActorId(int productId) {
//	Optional<Product> optional = repository.findById(productId);
//	if(optional.isPresent()) {
//		Product product = optional.get();
//		ResponceStructure<Product> responseStructure = new ResponceStructure<>();
//cross identity 202
//		responseStructure.setStatusCOde(HttpStatus.FOUND.value());
//		responseStructure.setMessage("Actor Object found successfully");
//		responseStructure.setDate(product);
//		return new ResponseEntity<ResponceStructure<Product>>(responseStructure, HttpStatus.OK);

//public ResponseEntity<ResponceStructure<Product>> saveProduct(Product product) {
//	Product p= repository.save(product);
//	return ResponseEntity.ok(
//			structure.setStatusCOde(HttpStatus.OK.value())
//			.setMessage("Deleted done")
//			.setDate(p));