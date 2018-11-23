package com.certification.springboot.repositories;

import com.certification.springboot.model.Author;
import org.springframework.data.repository.CrudRepository;


/**
 * Spring Data contains a bunch of repositories that have many implemented methods for saving, deleting, updating data
 * as CrudRepository in this example
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
