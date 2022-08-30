package ru.haulmont.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.haulmont.demo.entity.Book;
import ru.haulmont.demo.repository.BookRepository;
import ru.haulmont.demo.service.BookService;

import java.util.List;
@Service("bookService")
public class BookServiceImpl  implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public void createBook(Book book) {
        bookRepository.save(book);
    }
}
