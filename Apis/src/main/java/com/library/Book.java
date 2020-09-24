package com.library;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookid")
    private int bookid;
    @Column(name = "bookname")
    private String bookname;
    @Column(name = "bookprice")
    private  Double bookprice;
    @Column(name = "bookdesc")
    private String bookdesc;

    public Book() {
    }

    public Book(int bookid, String bookname, Double bookprice, String bookdesc) {
        this.bookid = bookid;
        this.bookname = bookname;
        this.bookprice = bookprice;
        this.bookdesc = bookdesc;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public Double getBookprice() {
        return bookprice;
    }

    public void setBookprice(Double bookprice) {
        this.bookprice = bookprice;
    }

    public String getBookdesc() {
        return bookdesc;
    }

    public void setBookdesc(String bookdesc) {
        this.bookdesc = bookdesc;
    }
}
