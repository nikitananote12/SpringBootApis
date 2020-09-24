package com.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public List<User> listAll(int bookid){
        List<User> users = new ArrayList<>();
        repo.findByBookBookid(bookid).forEach(users::add);
        return users;
    }


    public void save(User user)
    {
        repo.save(user);
    }

    public User get(Integer id){
        return repo.findById(id).get();
    }

    public  void delete(Integer id){
        repo.deleteById(id);
    }
}
