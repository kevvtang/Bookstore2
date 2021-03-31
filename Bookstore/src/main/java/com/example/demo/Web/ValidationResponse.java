package com.example.demo.Web;

import java.util.List;

public class ValidationResponse {
	
	private String status;
	private List<ErrorMessage> errorMessageList;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<ErrorMessage> getErrorMessageList() {
		return errorMessageList;
	}
	public void setErrorMessageList(List<ErrorMessage> errorMessageList) {
		this.errorMessageList = errorMessageList;
	}
	public ValidationResponse(String status, List<ErrorMessage> errorMessageList) {
		super();
		this.status = status;
		this.errorMessageList = errorMessageList;
	}
	public ValidationResponse() {
		
	}
	
	
}