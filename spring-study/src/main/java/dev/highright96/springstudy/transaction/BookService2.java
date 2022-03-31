package dev.highright96.springstudy.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService2 {

    @Autowired
    private BookRepository bookRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insert1() {
        bookRepository.save(new Book("오브젝트"));
        throw new NullPointerException();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insert2() {
        bookRepository.save(new Book("토비의 스프링"));
    }
}
