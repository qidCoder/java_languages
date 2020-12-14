package com.languages.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.languages.models.Language;
import com.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private LanguageRepository lRepo;

	public LanguageService(LanguageRepository repo) {
		this.lRepo = repo;
	}
	
	//CRUD methods
	//get all languages
	public List<Language> getAllLanguages(){
		return this.lRepo.findAll();
	}
	
	//get one language
	public Language getSingleLanguage(Long id) {
		return this.lRepo.findById(id).orElse(null);
	}
	
	//create
	public Language createLanguage(Language newLanguage) {
		return this.lRepo.save(newLanguage);
	}
	
	//delete
	public void deleteLanguage(Long id) {
		this.lRepo.deleteById(id);
	}
	
	//update
	public Language updateLanguage(Language language) {
		return this.lRepo.save(language);
	}
	
	
}
