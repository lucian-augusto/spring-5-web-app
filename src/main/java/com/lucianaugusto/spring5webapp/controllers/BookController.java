package com.lucianaugusto.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lucianaugusto.spring5webapp.repositories.BookRepository;

@Controller
public class BookController {
	
//	Attributes
	private final BookRepository bookRepository;
	
//	Constructors
	public BookController(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}


	@RequestMapping("/books")
	public String getBooks(Model model) {
		
		model.addAttribute("books", bookRepository.findAll());
		return "books/list";
	}
}
