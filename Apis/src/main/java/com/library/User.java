package com.library;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private int userid;
    @Column(name = "username")
    private String username;
    @ManyToOne
    @JoinColumn(name = "user_bookid",referencedColumnName = "bookid")
    private Book book;

    public User() {
    }

    public User(int userid, String username, int bookid) {
        super();
        this.userid = userid;
        this.username = username;
        this.book = new Book(bookid,"",0.0d,"");
    }


    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
