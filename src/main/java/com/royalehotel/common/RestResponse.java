package com.royalehotel.common;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class RestResponse 
{
	public Boolean success;
	public String message = null;
	public Object viewModel = null;
	public List<?> viewModels = null;
	public int statusCode;
	public String accessToken=null;
	
	public RestResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RestResponse(Boolean success, String message, Object viewModel, List<?> viewModels, int statusCode,
			String accessToken) {
		this.success = success;
		this.message = message;
		this.viewModel = viewModel;
		this.viewModels = viewModels;
		this.statusCode = statusCode;
		this.accessToken = accessToken;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getViewModel() {
		return viewModel;
	}
	public void setViewModel(Object viewModel) {
		this.viewModel = viewModel;
	}
	public List<?> getViewModels() {
		return viewModels;
	}
	public void setViewModels(List<?> viewModels) {
		this.viewModels = viewModels;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
}
