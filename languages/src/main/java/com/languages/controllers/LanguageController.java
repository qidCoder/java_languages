package com.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.languages.models.Language;
import com.languages.services.LanguageService;

@Controller
public class LanguageController {	
	@Autowired
	private LanguageService lService;
    
    //When a user visits "/languages", we want to show them all the languages that we have in our database.
	@GetMapping("/languages")
	public String homePage(Model model) {
		List<Language> allLanguages = this.lService.getAllLanguages();
		model.addAttribute("allLanguages", allLanguages);//for the table
		model.addAttribute("language", new Language());//for the form - makes an empty object to fill in by the user
		
		return "index.jsp";
	}
	
	@GetMapping("/")
	public String index() {
		return "redirect:/languages";
	}
    
    @RequestMapping(value="/add", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "index.jsp";//re-render page if errors
        } else {
            this.lService.createLanguage(language);
            return "redirect:/languages";
        }
    }
    
    //when the user visits '/languages/1', you are to respond with a view page that has all the information about a specific language.
    @GetMapping("/{id}")
    public String displayOne(@PathVariable("id") Long id, Model model) {
        model.addAttribute("language", lService.getSingleLanguage(id));
        
        return "/languages/display.jsp";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteOne(@PathVariable("id") Long id) {
        this.lService.deleteLanguage(id);
        
        return "redirect:/";
    }
    
    //update form view
    @GetMapping("/update/{id}")
    public String updateOne(@PathVariable("id") Long id, Model model) {
        model.addAttribute("language", lService.getSingleLanguage(id));
        
        return "edit.jsp";
    }
    
    //submit update to DB
    @RequestMapping(value="/update/{id}", method=RequestMethod.POST)
    public String update(Model viewModel, @Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";//re-render page if errors
        } else {
            this.lService.updateLanguage(language);
            return "redirect:/languages";
        }
    }
    
    //display the individual language
    @GetMapping("/show/{id}")
    public String showOne(@PathVariable("id") Long id, Model model) {
        model.addAttribute("language", lService.getSingleLanguage(id));
        
        return "show.jsp";
    }
    
}