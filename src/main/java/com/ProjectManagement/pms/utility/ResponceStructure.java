package com.ProjectManagement.pms.utility;

import org.springframework.stereotype.Component;
@Component
public class ResponceStructure<T> {
	private int statusCOde;
	private String message;
	private T date;
	public int getStatusCOde() {
		return statusCOde;
	}
	public ResponceStructure<T> setStatusCOde(int statusCOde) {
		this.statusCOde = statusCOde;
		return this;
	}
	public T getDate() {
		return date;
	}
	public ResponceStructure<T> setDate(T date) {
		this.date = date;
		return this;
	}
	public String getMessage() {
		return message;
	}
	public ResponceStructure<T> setMessage(String message) {
		this.message = message;
		return this;
	}

}
