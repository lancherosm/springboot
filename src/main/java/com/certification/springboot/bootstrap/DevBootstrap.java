package com.certification.springboot.bootstrap;

import com.certification.springboot.model.Author;
import com.certification.springboot.model.Book;
import com.certification.springboot.model.Publisher;
import com.certification.springboot.repositories.AuthorRepository;
import com.certification.springboot.repositories.BookRepository;
import com.certification.springboot.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * This class executes the initData method in deployment time
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;

    private BookRepository bookRepository;

    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
                        PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private void initdata(){

        //Eric
        Author eric = new Author("Eric", "Evans");
        Publisher harper = new Publisher("Harper", "Street 5");
        Book ddd = new Book("Domain Driven Design", "1234", harper);
        eric.getBooks().add(ddd);
        publisherRepository.save(harper);
        authorRepository.save(eric);
        bookRepository.save(ddd);

        //Rod
        Author rod = new Author("Rod", "Johnson");
        Publisher morx = new Publisher("Morx", "Street 1");
        Book noEJB = new Book("JEE without EJB", "5678", morx);
        rod.getBooks().add(noEJB);
        publisherRepository.save(morx);
        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initdata();
    }
}
