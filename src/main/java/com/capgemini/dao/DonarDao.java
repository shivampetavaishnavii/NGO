package com.capgemini.dao;

import java.util.List;

public interface DonarDao <D, ID> {
	List<D> findAll();

	D save(D donar);
	
	

}
