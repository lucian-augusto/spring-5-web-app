package com.lucianaugusto.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lucianaugusto.spring5webapp.repositories.AuthorRepository;

@Controller
public class AuthorController {

//	Attributes
	private final AuthorRepository authorRepository;

//	Constructors
	public AuthorController(AuthorRepository authorRepository) {
		super();
		this.authorRepository = authorRepository;
	}
	
//	Handling Request
	@RequestMapping("/authors")
	public String getAuthors(Model model) {
		
		model.addAttribute("authors", authorRepository.findAll());
		return "authors/list";
	}
	
}
