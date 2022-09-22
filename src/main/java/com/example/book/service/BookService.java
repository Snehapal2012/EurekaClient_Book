package com.example.book.service;


import com.example.book.dto.BookDTO;
import com.example.book.exception.BookException;
import com.example.book.model.Book;
import com.example.book.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService{
    //Create dependency injection for bookRepo class
    @Autowired
    BookRepo bookRepo;
    //Apply logic for Insert book details in the database
    @Override
    public Book insert(BookDTO bookDTO){
        Book book=new Book(bookDTO);
        bookRepo.save(book);
        return book;
    }
    //Apply logic for Getting all book details present in the database
    @Override
    public List<Book> getAllBook(){
        List<Book> bookList=bookRepo.findAll();
        return bookList;
    }
    //Apply logic for Getting particular book details which will be found by id
    @Override
    public Optional<Book> getById(long id){
        Optional<Book> book=bookRepo.findById(id);
        if(book.isPresent()){
            return book;
        }else {
            throw new BookException("Sorry! We can not find the book id: "+id);
        }
    }
    @Override
    public Book getDetailsById(long id){
        Book book=bookRepo.findById(id).get();
        if(bookRepo.findById(id).isPresent()){
            return book;
        }else {
            throw new BookException("Book id is not present! please check and try again!");
        }
    }
    //Apply logic for Deleting particular book details which will be found by id
    @Override
    public void deleteById(long id){
        Optional<Book> book=bookRepo.findById(id);
        if(book.isPresent()){
            bookRepo.deleteById(id);
        }else {
            throw new BookException("Sorry! We can not find the book id: "+id);
        }
    }
    //Apply logic for Searching particular book details by its name
    @Override
    public Book searchByBookName(String name){
        Book book=bookRepo.findByName(name);
        if(bookRepo.findByName(name)==null){
            throw new BookException("Sorry! We can not find your book name: "+name);
        }else {
            return book;
        }
    }
    //Apply logic for Updating particular book details which will be found by id
    @Override
    public Book updateBookById(BookDTO bookDTO,long id){
        Book book=bookRepo.findById(id).get();
        if(bookRepo.findById(id).isPresent()){
            book.setBookName(bookDTO.getBookName());
            book.setAuthorName(bookDTO.getAuthorName());
            book.setBookDescription(book.getBookDescription());
            book.setBookImg(bookDTO.getBookImg());
            book.setPrice(bookDTO.getPrice());
            book.setQuantity(bookDTO.getQuantity());
            bookRepo.save(book);
            return book;
        }else {
            throw new BookException("Sorry! We can not find entered id: "+id);
        }
    }
    //Apply logic for Sorting all book details by the price in ascending order
    @Override
    public List<Book> sortingAsce(){
        List<Book> bookList=bookRepo.sortingAsce();
        return bookList;
    }
    //Apply logic for Sorting all book details by the price in descending order
    @Override
    public List<Book> sortingDsce(){
        List<Book> bookList=bookRepo.sortingDsce();
        return bookList;
    }
    //Apply logic for Updating quantity for particular book which will be found by id
    @Override
    public Book updateQuantity(BookDTO bookDTO,long id){
        Optional<Book> bookList=bookRepo.findById(id);
        if(bookList.isPresent()){
            Book book=bookRepo.findById(id).get();
            bookRepo.save(book);
            return book;
        }else {
            throw new BookException("Sorry! We can not find entered id: "+id);
        }
    }
}
