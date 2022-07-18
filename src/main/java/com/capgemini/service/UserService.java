package com.capgemini.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dao.UserDao;
import com.capgemini.model.User;
import com.capgemini.repository.UserRepository;

@Service
public class UserService implements UserDao<User, Integer> {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
       
        user= userRepository.save(user);
        return user;
    }

	@Override
	public List<User> findAll() {
		List<User> userAdmin = (List<User>) userRepository.findAll();
        return userAdmin;
		
	}
	public User checkUserNamePassword(String userName,String password){
        User user=userRepository.findByUsernameAndPassword(userName,password);
        return user;
    }       

   

}
