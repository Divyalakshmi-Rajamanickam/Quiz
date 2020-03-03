package com.github.divya.Quiz.service;

import com.github.divya.Quiz.model.User;
import com.github.divya.Quiz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository repository) {
        this.userRepository = repository;
    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        userRepository.findAll().forEach(x -> userList.add(x));
        return userList;
    }

    public User create(User user) {
        System.out.println("userService.create: " + user);
        User userCreated = userRepository.save(user);
        return userCreated;
    }


    public User get(Integer id) {
        Optional<User> potentialUser = userRepository.findById(id);
        User user = potentialUser.get();
        return user;
    }


    public User update(Integer id, User user) {
        User userInDataBase = get(id);
        Integer newUserId = user.getUserId();
        String newUserName = user.getUserName();
        String newPassword = user.getPassword();
        String newFirstName = user.getFirstName();
        String newLastName = user.getLastName();
        String newEmail = user.getEmail();
        String newType = user.getType();

        userInDataBase.setUserId(newUserId);
        userInDataBase.setUserName(newUserName);
        userInDataBase.setPassword(newPassword);
        userInDataBase.setFirstName(newFirstName);
        userInDataBase.setLastName(newLastName);
        userInDataBase.setEmail(newEmail);
        userInDataBase.setType(newType);
        userRepository.save(userInDataBase);
        return userInDataBase;
    }

    public User delete(Integer id) {
        User user = get(id);
        userRepository.delete(user);
        return user;
    }

    public User loginUser(User user) {
        userRepository.
    }
}
