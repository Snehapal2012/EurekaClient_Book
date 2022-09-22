package com.example.book.service;

import com.example.book.dto.BookDTO;
import com.example.book.model.Book;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    Book insert(BookDTO bookDTO);

    List<Book> getAllBook();

    Optional<Book> getById(long id);

    void deleteById(long id);

    Book searchByBookName(String name);

    Book updateBookById(BookDTO bookDTO, long id);

    List<Book> sortingAsce();

    List<Book> sortingDsce();

    Book updateQuantity(BookDTO bookDTO, long id);

    Book getDetailsById(long id);
}
