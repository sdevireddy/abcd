package com.royalehotel.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.royalehotel.model.Language;

public interface LanguageRepositiory extends JpaRepository<Language, Long> {

	Language save(Language language);
	//List<Language> saveAll(List<Language> languages);
	List<Language> findAll();
	Optional<Language> findById(Long id);
}
