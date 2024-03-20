package com.ProjectManagement.pms.Controller;

import java.util.List;

import org.springframework.context.annotation.Description;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ProjectManagement.pms.Service.ProductService;
import com.ProjectManagement.pms.dto.ProductRequest;
import com.ProjectManagement.pms.model.Product;
import com.ProjectManagement.pms.utility.ErrorStructure;
import com.ProjectManagement.pms.utility.ErrorStructures;
import com.ProjectManagement.pms.utility.ResponceStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
public class ProductController {

	private ProductService service;

	public ProductController(ProductService service) {
		super();
		this.service = service;
	}

	@Operation(description = "This end point is for add the product", responses = {
	@ApiResponse(responseCode = "200",description = "Product saved successfully"),
	@ApiResponse(responseCode = "404",description = "product not saved")})
	@PostMapping(value = "/products")
	public ResponseEntity<ResponceStructure<Product>> saveProduct(@RequestBody ProductRequest productRequest){
		return service.saveProduct(productRequest);
	}

	@Operation(description = "This is for find all the products",responses = {@ApiResponse(responseCode = "200",description = "Product si found successfully")})
	@GetMapping(value="/products")
	public ResponseEntity<ResponceStructure<List<Product>>> findAllProduct() {
		return service.findAll();
	}

	@Operation(description = "This is for find the product using id", responses = {
			@ApiResponse(responseCode = "200",description = "Product found"),
			@ApiResponse(responseCode = "404",description = "product not found by ID",
			content= {
					@Content(schema = @Schema(implementation = ErrorStructure.class))
			})
	})
	@GetMapping(value = "/products/{productId}")
	public ResponseEntity<ResponceStructure<Product>> findByProductId(@PathVariable int productId) {
		return service.findByActorId(productId);
	}

	@Operation(description = "This end point is for delete the product", responses = {@ApiResponse(responseCode = "200",description = "Product deleted successfully"),
			@ApiResponse(responseCode = "404",description = "product not found")})
	@DeleteMapping(value = "/product/{productId}")
	public ResponseEntity<ResponceStructure<Product>> deleteByActorId(@PathVariable int productId) {
		return service.deleteById(productId);
	}

	@PutMapping(value = "/products/{productId}")
	public ResponseEntity<ResponceStructure<Product>> updateById(@PathVariable int productId,@RequestBody Product product) {
		return service.updateById(productId,product);
	}


}
