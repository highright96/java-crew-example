package dev.highright96.springstudy.transaction;

import java.util.List;

public interface BookService {

    void addBooks(List<String> bookNames);

    void addBook(String bookName);

    void invoke();
}
