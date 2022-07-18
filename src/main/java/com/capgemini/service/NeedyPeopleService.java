package com.capgemini.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.capgemini.dao.NeedyPeopleDao;

import com.capgemini.model.NeedyPeople;
import com.capgemini.repository.NeedyPeopleRepository;
@Service
public class NeedyPeopleService implements NeedyPeopleDao<NeedyPeople, Integer> {
	@Autowired
    private NeedyPeopleRepository needypeopleRepository;
    @Override
    public NeedyPeople save(NeedyPeople needypeople) {
       
        needypeople= needypeopleRepository.save(needypeople);
        return needypeople;
    }
    @Override
	public List<NeedyPeople> findAll() {
		List<NeedyPeople> needypeoples = (List<NeedyPeople>) needypeopleRepository.findAll();
        return needypeoples;
		
	}
	public NeedyPeople checkUserNamePassword(String userName,String password){
        NeedyPeople needypeople=needypeopleRepository.findByUsernameAndPassword(userName,password);
        return needypeople;
    }
	public NeedyPeople getNeedyById(Integer id) {
		
		return null;
	}
	public NeedyPeople addNeedyPeople(NeedyPeople needypeople) {
		return needypeopleRepository.save(needypeople);
	}
	public void deleteNeedyPeople(Integer needypeopleId) {
		needypeopleRepository.deleteById(needypeopleId);
	}
	public NeedyPeople updateNeedyPeople(NeedyPeople needypeople, Integer needypeopleId) {
		Optional<NeedyPeople> needypeopleData = needypeopleRepository.findById(needypeopleId);
		if (needypeopleData.isPresent()) {
			needypeople.setNeedypersonId(needypeople.getNeedypersonId());
			needypeople.setNeedypersonName(needypeople.getNeedypersonName());
			needypeople.setEmail(needypeople.getEmail());
			needypeople.setPassword(needypeople.getPassword());
			needypeople.setPhone(needypeople.getPhone());
			needypeople.setUsername(needypeople.getUsername());
			needypeople.setFamilyIncome(needypeople.getFamilyIncome());
			return needypeopleRepository.save(needypeople);
		}else {
				return null;
			}
	}       

}
