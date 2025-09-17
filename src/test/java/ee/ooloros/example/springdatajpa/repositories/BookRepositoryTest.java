package ee.ooloros.example.springdatajpa.repositories;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ee.ooloros.example.springdatajpa.entities.Book;

import static org.assertj.core.api.Assertions.assertThat;

class BookRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void shouldDeleteOneByTitle() {
        long count = bookRepository.deleteByTitle("Pride and Prejudice");
        assertThat(count).isEqualTo(1);
    }

    @Test
    void shouldDeleteMultipleByTitle() {
        long count = bookRepository.deleteByTitle("The Trial");
        assertThat(count).isEqualTo(2);
    }

    @Test
    void shouldDeleteOneByAuthor() {
        Long count = bookRepository.deleteByAuthor("Victor Hugo");
        assertThat(count).isEqualTo(1);
    }

    @Test
    void shouldDeleteMultipleByAuthor() {
        Long count = bookRepository.deleteByAuthor("Franz Kafka");
        assertThat(count).isEqualTo(2);
    }

    @Test
    void shouldDeleteByLanguage() {
        List<String> expected = List.of("Don Quixote", "One Hundred Years of Solitude");

        List<Book> deleted = bookRepository.deleteByLanguage("Spanish");
        assertThat(deleted)
                .extracting(Book::getTitle)
                .isEqualTo(expected);
    }

}