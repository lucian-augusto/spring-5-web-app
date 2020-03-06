package com.lucianaugusto.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.lucianaugusto.spring5webapp.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
