package com.capgemini.repository;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.model.Donar;



public interface DonarRepository extends CrudRepository<Donar, Integer> {

    

    Donar findByUsernameAndPassword(String userName, String password);

}
