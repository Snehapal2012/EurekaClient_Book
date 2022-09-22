package com.example.book.model;

import com.example.book.dto.BookDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@Table(name = "book")
@NoArgsConstructor

public class Book {
    //Book table attributes
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookId;
    private String bookName;
    private String authorName;
    private String bookDescription;
    private String bookImg;
    private long price;
    private long quantity;
    //Create Constructor
    public Book(BookDTO bookDTO){
        this.bookName=bookDTO.getBookName();
        this.authorName=bookDTO.getAuthorName();
        this.bookDescription=bookDTO.getBookDescription();
        this.bookImg=bookDTO.getBookImg();
        this.price=bookDTO.getPrice();
        this.quantity=bookDTO.getQuantity();
    }
}
