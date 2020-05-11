package com.royalehotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.royalehotel.common.RestResponse;
import com.royalehotel.service.CommonService;

@Service
public class CommonServiceImpl implements CommonService {
	
	@Autowired
	RestResponse response;

	public RestResponse createResponse(List<?> items) {
		response.setSuccess(true);
		response.setStatusCode(HttpStatus.OK.value());
		if (items != null && items.size() > 1) {
			response.setViewModels(items);
		} else {
			response.setViewModels(items);
		}
		return response;
	}
}
