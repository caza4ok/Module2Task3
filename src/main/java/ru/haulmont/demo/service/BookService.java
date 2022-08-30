package ru.haulmont.demo.service;

import ru.haulmont.demo.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBook();

    void createBook(Book book);
}
