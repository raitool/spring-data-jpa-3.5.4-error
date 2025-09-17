package ee.ooloros.example.springdatajpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ee.ooloros.example.springdatajpa.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    long deleteByTitle(String title);

    Long deleteByAuthor(String author);

    List<Book> deleteByLanguage(String language);
}