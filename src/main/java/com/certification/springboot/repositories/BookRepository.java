package com.certification.springboot.repositories;

import com.certification.springboot.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
