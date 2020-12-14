package com.languages.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.languages.models.Language;
import com.languages.services.LanguageService;

@RestController
@RequestMapping("/api")
public class APILanguageController {
	private LanguageService lService;

	public APILanguageController(LanguageService service) {
		this.lService = service;
	}
	
	//create routes
	@RequestMapping(value="", method = RequestMethod.GET)
	public List<Language> homePage() {
		return this.lService.getAllLanguages();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public Language getLanguage(@PathVariable("id") Long id) {
		return this.lService.getSingleLanguage(id);
	}
	
	@RequestMapping(value="", method = RequestMethod.POST)
	public Language create(Language language) {
		return this.lService.createLanguage(language);
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
	public void deleteLanguage(@PathVariable("id") Long id) {
		this.lService.deleteLanguage(id);
	}
	
	@RequestMapping(value="/update/{id}", method = RequestMethod.PUT)
	public Language updateLanguage(Language language, @PathVariable("id") Long id) {
		return this.lService.updateLanguage(language);
	}
	
	
	

}
