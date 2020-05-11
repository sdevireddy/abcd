package com.royalehotel.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.royalehotel.exceptions.ValidationException;
import com.royalehotel.model.Country;
import com.royalehotel.model.Language;
import com.royalehotel.model.State;
import com.royalehotel.model.User;
import com.royalehotel.repository.CountryRepositiory;
import com.royalehotel.repository.LanguageRepositiory;
import com.royalehotel.repository.StateRepositiory;
import com.royalehotel.repository.UserRepository;

@Service
public class LanguageServiceImpl implements LanguageService {

	@Autowired
	LanguageRepositiory languageRepository;

	@Override
	public Language save(Language language) {
		if(!isValid(language)) {
			throw new ValidationException("code, name are manadatory");
		}
		if(language.getStatus().equals("1") && languageRepository.findByNameAndCode(language.getName(), language.getCode()).size()>0) {
			throw new ValidationException("language with this code and name already exists");			
		}
		if(language.getStatus().equals("0") && languageRepository.findById(language.getId()) != null ) {
			languageRepository.deleteById(language.getId());
			return language;
		}else {
			return languageRepository.save(language);
		}		
	}	
	
	@Override
	public List<Language> saveAll(List<Language> languages) {
		List<Language> validLanguages = languages.stream().filter(lang -> isValid(lang) && languageRepository.findByNameAndCode(lang.getName(), lang.getCode()) != null).collect(Collectors.toList());
		return languageRepository.saveAll(validLanguages);
	}

	@Override
	public Optional<Language> findByLanguageId(Long id) {		
		return languageRepository.findById(id);
	}

	@Override
	public List<Language> findAll() {
		return languageRepository.findAll();
	}
	
	public boolean isValid(Language language) {
		if(language.getName() == null || language.getName().isEmpty())
			return false;
		if(language.getCode() == null || language.getCode().isEmpty())
			return false;		
		return true;		
	}
}
