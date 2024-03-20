package com.ProjectManagement.pms.utility;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class ErrorStructures <T>{
	private int statusCode;
	private String errorMessage;
	private T errorData;
}
