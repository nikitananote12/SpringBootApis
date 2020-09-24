package com.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository repo;
    public List<Book> listAll(){
        return repo.findAll();
    }
    public void save(Book book){
        repo.save(book);
    }
    public Book get(Integer bookid){
        return repo.findById(bookid).get();
    }
    public  void delete(Integer bookid){
        repo.deleteById(bookid);
    }
}
