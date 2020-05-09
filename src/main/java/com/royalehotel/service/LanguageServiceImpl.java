package com.royalehotel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		return languageRepository.save(language);
	}
	
	@Override
	public List<Language> saveAll(List<Language> language) {
		return languageRepository.saveAll(language);
	}

	@Override
	public Optional<State> findByLanguageId(Long id) {
		return null;
	}

	@Override
	public List<State> findAll() {
		return null;
	}
}
