package com.certification.springboot.repositories;

import com.certification.springboot.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
