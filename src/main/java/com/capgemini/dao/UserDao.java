package com.capgemini.dao;

import java.util.List;

public interface UserDao <USER, ID> {
	List<USER> findAll();

	USER save(USER u); 

}
