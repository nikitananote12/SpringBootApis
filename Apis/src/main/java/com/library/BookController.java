package com.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class BookController {
    @Autowired
    private  BookService service;
    @GetMapping("/books")
    public List<Book> list(){
        return service.listAll();
    }
    @GetMapping("/books/{bookid}")
    public ResponseEntity<Book> get(@PathVariable Integer bookid){
        try {
            Book book = service.get(bookid);
            return new ResponseEntity<Book>(book, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/books")
    public void add(@RequestBody Book book){
        service.save(book);
    }
    @PutMapping("/books/{bookid}")
    public ResponseEntity<?> update(@RequestBody Book book, @PathVariable Integer bookid){
        try{
            Book existbook = service.get(bookid);
            service.save(book);
            return  new ResponseEntity<>(HttpStatus.OK);
        }catch (NoSuchElementException e){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/books/{bookid}")
    public void delete(@PathVariable Integer bookid){
        service.delete(bookid);
    }
}
