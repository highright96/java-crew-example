package dev.highright96.springstudy.transaction;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTest {

    @Autowired
    BookService bookService;

    @Autowired
    BookRepository bookRepository;

    @Test
    void transaction_test1() {
        List<String> bookNames = List.of("book1", "book2");
        bookService.addBooks(bookNames);

        List<Book> books = bookRepository.findAll();
        assertThat(books.get(0).isFlag()).isTrue();
    }

    @Test
    void transaction_test() {
        bookService.invoke();
    }
}
