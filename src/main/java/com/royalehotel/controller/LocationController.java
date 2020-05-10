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
import com.royalehotel.model.CarDetails;
import com.royalehotel.model.CarType;
import com.royalehotel.model.City;
import com.royalehotel.model.Country;
import com.royalehotel.model.Language;
import com.royalehotel.model.State;
import com.royalehotel.repository.CarDetailsRepositiory;
import com.royalehotel.repository.CarTypeRepositiory;
import com.royalehotel.repository.CountryRepositiory;
import com.royalehotel.repository.LanguageRepositiory;
import com.royalehotel.service.CityService;
import com.royalehotel.service.ContryService;
import com.royalehotel.service.StateService;
import com.royalehotel.exceptions.ValidationException;

@RestController
@RequestMapping(value = "/api")
public class LocationController {

	@Autowired
	ContryService countryService;

	@Autowired
	StateService stateService;
	
	@Autowired
	CityService cityService;

	@Autowired
	RestResponse response;

	@Autowired
	LanguageRepositiory repository;

	@Autowired
	CarTypeRepositiory carTypeRepository;

	@Autowired
	CarDetailsRepositiory carDetailsRepository;

	@PostMapping("/country")
	public Country getCountry(@RequestBody Country country) {		
		return countryService.save(country);		
	}

	/*
	 * @GetMapping("/country") public List<Country> getAllCountries() { return
	 * countryService.findAll(); }
	 */

	@GetMapping("/country")
	public RestResponse getAllCountries() {
		return createResponse(countryService.findAll());
	}

	@GetMapping("/country/{name}")
	public RestResponse getCountryByName(@PathVariable String name) {
		return createResponse(Arrays.asList(countryService.findByName(name)));
	}


	@PostMapping("/state")
	public State getState(@RequestBody State state) {
		return stateService.save(state);
	}

	/*
	 * @GetMapping("/state") public List<State> getAllStates() { return
	 * stateService.findAll(); }
	 */

	@GetMapping("/state/{name}")
	public RestResponse getByName(@PathVariable String name) {
		return createResponse(Arrays.asList(stateService.findByName(name)));
	}

	@GetMapping("/state")
	public RestResponse getState(@RequestParam(name = "countryid", required = false) Long name) {
		if (StringUtils.isEmpty(name)) {
			return createResponse(stateService.findAll());
		} else {
			return createResponse(Arrays.asList(stateService.findByCountryId(name)));
		}
	}
	
	@PostMapping("/city")
	public City postCity(@RequestBody City city) {
		return cityService.save(city);
	}
	
	@GetMapping("/city")
	public RestResponse getCities(@RequestParam(name = "stateid", required=false) Long stateId) {
		if(StringUtils.isEmpty(stateId)) {
			return createResponse(cityService.findAll());
		}else {
			return createResponse(cityService.findByStateId(stateId));
		}
	}

	@PostMapping("/languages")
	public RestResponse language(@RequestBody List<Language> language) {
		return createResponse(Arrays.asList(repository.save(language)));
	}

	@PostMapping("/cartype")
	public RestResponse carType(@RequestBody CarType language) {
		return createResponse(Arrays.asList(carTypeRepository.save(language)));
	}

	@PostMapping("/carcompany")
	public RestResponse carCompany(@RequestBody CarDetails language) {
		return createResponse(Arrays.asList(carDetailsRepository.save(language)));
	}

	/*
	 * @GetMapping("/country/{id}") public Optional<Country>
	 * getCountryById(@PathVariable Long id) { return stateService.findById(id); }
	 */

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
