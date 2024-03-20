package com.ProjectManagement.pms.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ProjectManagement.pms.Exception.ProductNotFoundById;

@ControllerAdvice
@ResponseBody
public class AppHandler {
	@ExceptionHandler
	public ResponseEntity<ErrorStructures> errorStructure(ProductNotFoundById es){
		
		ErrorStructures<String> errorstructure = new ErrorStructures<String>();
		errorstructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		errorstructure.setErrorMessage("Product is not found");
		errorstructure.setErrorData(es.getMessage());
		
		return new ResponseEntity<ErrorStructures>(errorstructure,HttpStatus.NOT_FOUND);
	}

}
