package com.royalehotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.royalehotel.common.RestResponse;

@Service
public interface CommonService {	
	public RestResponse createResponse(List<?> items); 
}
