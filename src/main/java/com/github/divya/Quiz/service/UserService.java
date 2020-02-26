package com.github.divya.Quiz.service;

import com.github.divya.Quiz.model.User;
import com.github.divya.Quiz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        repository.findAll().forEach(x -> userList.add(x));
        return userList;
    }

    public User create(User user) {
        User userCreated = repository.save(user);
        return userCreated;
    }


    public User get(Integer id) {
        Optional<User> potentialUser = repository.findById(id);
        User user = potentialUser.get();
        return user;
    }


    public User update(Integer id, User user) {
        User userInDataBase = get(id);
        String newFirstName = user.getFirstName();
        String newLastName = user.getLastName();

        userInDataBase.setFirstName(newFirstName);
        userInDataBase.setLastName(newLastName);
        repository.save(userInDataBase);
        return userInDataBase;
    }

    public User delete(Integer id) {
        User user = get(id);
        repository.delete(user);
        return user;
    }



}
