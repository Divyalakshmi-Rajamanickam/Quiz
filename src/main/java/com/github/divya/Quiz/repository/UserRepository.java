package com.github.divya.Quiz.repository;

import com.github.divya.Quiz.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
<<<<<<< HEAD
public interface UserRepository extends CrudRepository<User,Integer> {
=======
public interface UserRepository extends CrudRepository<User,Integer>,JpaRepository<User, Integer> {

      //User findUser(String userName,String password);
>>>>>>> 50b07fba8203ba288f7f8c5220eeaa6e41a0d11c
}
