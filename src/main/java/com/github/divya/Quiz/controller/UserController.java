package com.github.divya.Quiz.controller;

import com.github.divya.Quiz.model.User;
import com.github.divya.Quiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> responseBody = service.getAllUsers();
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value="/create", method= RequestMethod.POST)
      public  ResponseEntity<User> create(@RequestBody User user){
        User responseBody = (User) service.create(user);
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
            return responseEntity;
    }


    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public ResponseEntity<User> get(@PathVariable Integer id) {
       User responseBody = service.get(id);
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return  responseEntity;
    }


    @RequestMapping(value="/update", method=RequestMethod.PUT)
    public ResponseEntity<User> update(@PathVariable Integer id, @RequestBody User user){
        User responseBody = service.update(id,user);
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody,HttpStatus.OK);
    return responseEntity;
    }


    @RequestMapping(value="/delete", method=RequestMethod.DELETE)
    public ResponseEntity<User> delete(@PathVariable Integer id){
       User responseBody = service.delete(id);
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }
}
