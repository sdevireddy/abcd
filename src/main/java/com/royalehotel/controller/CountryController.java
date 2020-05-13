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
import com.royalehotel.model.Country;
import com.royalehotel.repository.CountryRepositiory;
import com.royalehotel.exceptions.ValidationException;
import com.royalehotel.service.ContryService;
import com.royalehotel.service.CommonService;

@RestController
@RequestMapping(value = "/api")

public class CountryController {
	@Autowired
	ContryService countryService;

	@Autowired
	CommonService commonService;

	@PostMapping("/country")
	public Country getCountry(@RequestBody Country country) {
		return countryService.save(country);
	}

	@GetMapping("/countries")
	public RestResponse getAllCountries() {
		return commonService.createResponse(countryService.findAll());
	}

	@GetMapping("/country/{id}")
	public RestResponse getCountryById(@PathVariable Long id) {
		return commonService.createResponse(Arrays.asList(countryService.findById(id)));
	}
}
