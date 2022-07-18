package com.capgemini.repository;

import org.springframework.data.repository.CrudRepository;


import com.capgemini.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

    

    User findByUsernameAndPassword(String userName, String password);

}