package com.capgemini.repository;


import com.capgemini.model.Employee;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends CrudRepository<Employee, Integer> {

    

   Employee findByUsernameAndPassword(String userName, String password);
    
    

    
}