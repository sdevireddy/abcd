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
import com.royalehotel.model.Language;
import com.royalehotel.repository.LanguageRepositiory;
import com.royalehotel.exceptions.ValidationException;
import com.royalehotel.service.LanguageService;
import com.royalehotel.service.CommonService;



@RestController
@RequestMapping(value = "/api")

public class LanguageController {
	
	@Autowired
	LanguageService languageService;
	
	@Autowired
	CommonService commonService;
	
	@PostMapping("/languages")
	public RestResponse languages(@RequestBody List<Language> languages) {
		return commonService.createResponse(languageService.saveAll(languages));
	}
	
	@PostMapping("/language")
	public RestResponse language(@RequestBody Language language) {
		return commonService.createResponse(Arrays.asList(languageService.save(language)));
	}
	
	@GetMapping("/language/{id}")
	public RestResponse getLanguage(@PathVariable Long id) {		
		return commonService.createResponse(Arrays.asList(languageService.findByLanguageId(id)));
				
	}	
	
	@GetMapping("/languages")
	public RestResponse getLanguages() {		
		return commonService.createResponse(Arrays.asList(languageService.findAll()));		
	}	
}

