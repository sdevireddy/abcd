package com.royalehotel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.royalehotel.model.Country;
import com.royalehotel.model.Language;
import com.royalehotel.model.State;
import com.royalehotel.model.User;
import com.royalehotel.repository.UserRepository;

@Service
public interface LanguageService {
	Language save(Language user);

	Optional<Language> findByLanguageId(Long id);

	List<Language> findAll();

	List<Language> saveAll(List<Language> language);

}
