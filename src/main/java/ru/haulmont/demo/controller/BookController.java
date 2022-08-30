package ru.haulmont.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.haulmont.demo.entity.Book;
import ru.haulmont.demo.repository.BookRepository;
import ru.haulmont.demo.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookRepository bookRepository;

    private final BookService bookService;

    @Autowired
    public BookController(BookRepository bookRepository, BookService bookService) {
        this.bookRepository = bookRepository;
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBook()
    {
        return new ResponseEntity<>(bookService.getAllBook(), HttpStatus.OK);
    }

    @GetMapping("/create")
    public ResponseEntity<Book> createBook(@RequestParam String name, @RequestParam int yearCreate)
    {
        Book book = new Book();
        book.setName(name);
        book.setYearCreate(yearCreate);
        bookRepository.save(book);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

}
