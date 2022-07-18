package com.capgemini.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.model.NeedyPeople;

@Repository
public interface NeedyPeopleRepository extends CrudRepository<NeedyPeople, Integer> {

    

    NeedyPeople findByUsernameAndPassword(String userName, String password);

}
