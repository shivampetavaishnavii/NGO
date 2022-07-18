package com.capgemini.dao;


import java.util.List;


/*public interface EmployeeDao<T, ID>  extends UserDetailsService {*/
public interface EmployeeDao<T, ID> {
	List<T> findAll();

	T save(T t);
}
