package com.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class UserController {
    @Autowired
    private  UserService service;
    @GetMapping("books/{bookid}/users")
    public List<User> list(@PathVariable int bookid){

        return service.listAll(bookid);
    }
    @GetMapping("books/{id}/users/{userid}")
    public ResponseEntity<User> get(@PathVariable Integer userid){
        try {
            User user = service.get(userid);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("books/{bookid}/users")
    public void add(@RequestBody User user, @PathVariable int bookid){

        user.setBook(new Book(bookid,"",0.0d,""));
        service.save(user);
    }

    @PutMapping("books/{bookid}/users/{userid}")
    public ResponseEntity<?> update(@RequestBody User user, @PathVariable Integer bookid, @PathVariable Integer userid){
        try{
            user.setBook(new Book(bookid,"",0.0d,""));
            User existBook = service.get(userid);
            service.save(user);
            return  new ResponseEntity<>(HttpStatus.OK);
        }catch (NoSuchElementException e){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("books/{id}/users/{userid}")
    public void delete(@PathVariable Integer userid){
        service.delete(userid);
    }
}
