package com.capgemini.dao;

import java.util.List;

public interface NeedyPeopleDao <NP, ID> {
	List<NP> findAll();

	NP save(NP np);

}
