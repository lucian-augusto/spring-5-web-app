package com.lucianaugusto.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.lucianaugusto.spring5webapp.domain.Author;
import com.lucianaugusto.spring5webapp.domain.Book;
import com.lucianaugusto.spring5webapp.domain.Publisher;
import com.lucianaugusto.spring5webapp.repositories.AuthorRepository;
import com.lucianaugusto.spring5webapp.repositories.BookRepository;
import com.lucianaugusto.spring5webapp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
//	Constructors
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}


	@Override
	public void run(String... args) throws Exception {
		
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design", "123123");
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		Publisher barnesAndNoble = new Publisher("Barnes & Noble", "XXXX", "New York", "NY", "XXX-XXX");
		publisherRepository.save(barnesAndNoble);
		
		ddd.setPublisher(barnesAndNoble);
		barnesAndNoble.getBooks().add(ddd);
		
		authorRepository.save(eric);
		bookRepository.save(ddd);
		publisherRepository.save(barnesAndNoble);
		
		Author rod = new Author("Rod", "Johnson");
		Book noEJB = new Book("J2EE Development without EJB", "3939459459");
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		
		noEJB.setPublisher(barnesAndNoble);
		barnesAndNoble.getBooks().add(noEJB);
		
		authorRepository.save(rod);
		bookRepository.save(noEJB);
		publisherRepository.save(barnesAndNoble);
		
		System.out.println("Started in Bootstrap");
		System.out.println("Number of Books: " + bookRepository.count());
		
		System.out.println("Number of Publishers: " + publisherRepository.count());
		System.out.println("Publisher Number of Books: " + barnesAndNoble.getBooks().size());
	}

}
