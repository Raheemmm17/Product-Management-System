package com.ProjectManagement.pms.Exception;

public class ProductNotFoundById extends RuntimeException
{
	private String message;

	public ProductNotFoundById(String message) {
		super();
		this.message = message;
	}
	@Override
	public String getMessage() {
		return message;
	}
}
