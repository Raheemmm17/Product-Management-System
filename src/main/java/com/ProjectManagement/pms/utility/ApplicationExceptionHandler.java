package com.ProjectManagement.pms.utility;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler{
	private ErrorStructure structure;

	public ApplicationExceptionHandler(ErrorStructure structure) {
		super();
		this.structure = structure;
	}

	protected ResponseEntity<Object> handlerMethodArgumentNotValid(MethodArgumentNotValidException ex,HttpHeaders header, HttpStatusCode statusCode, WebRequest request){
		List<ObjectError> errors = ex.getAllErrors();
		Map<String , String> messages = new HashMap<String, String>();

		errors.forEach(error->{
			messages.put(((FieldError)error).getField(), error.getDefaultMessage());
		});

		//		errors.forEach(error->{
		//			FieldError fielderror = (FieldError)error;
		//			String string = fielderror.getField();
		//			String message = error.getDefaultMessage();
		//			messages.put(string, message);
		//		});

		return ResponseEntity.badRequest().body(structure.setStatusCode(HttpStatus.BAD_REQUEST.value())
				.setErrorMessage("Invalid Request")
				.setRootCause(messages));


	}
}
