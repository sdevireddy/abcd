package com.royalehotel.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.royalehotel.common.RestResponse;
import com.royalehotel.model.City;
import com.royalehotel.model.City;
import com.royalehotel.repository.CityRepositiory;
import com.royalehotel.exceptions.ValidationException;
import com.royalehotel.service.CityService;
import com.royalehotel.service.CommonService;

@RestController
@RequestMapping(value = "/api")

public class CityController {
	@Autowired
	CityService cityService;

	@Autowired
	CommonService commonService;
	
	@Autowired
	CityRepositiory cityRepositiory;

	@PostMapping("/city")
	public City postCity(@RequestBody City city) {
		return cityService.save(city);
	}

	@GetMapping("/city/{id}")
	public RestResponse getCity(@PathVariable Long id) {
		return commonService.createResponse(Arrays.asList(cityRepositiory.findById(id)));
	}

	@GetMapping("/city")
	public RestResponse getCities(@RequestParam(name = "stateid", required = false) Long stateId) {
		if (StringUtils.isEmpty(stateId)) {
			return commonService.createResponse(cityService.findAll());
		} else {
			return commonService.createResponse(cityService.findByStateId(stateId));
		}
	}

}
