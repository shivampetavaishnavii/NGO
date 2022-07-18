package com.capgemini.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dao.DonarDao;
import com.capgemini.model.Donar;
import com.capgemini.model.Employee;
import com.capgemini.repository.DonarRepository;


@Service
public class DonarService implements DonarDao<Donar, Integer> {
    @Autowired
    private DonarRepository donarRepository;

    @Override
    public Donar save(Donar donar) {
       
        donar= donarRepository.save(donar);
        return donar;
    }

	@Override
	public List<Donar> findAll() {
		List<Donar> donars = (List<Donar>) donarRepository.findAll();
        return donars;
		
	}
	public Donar checkUserNamePassword(String userName,String password){
        Donar donar=donarRepository.findByUsernameAndPassword(userName,password);
        return donar;
    }

	public Donar getDonarById(Integer id) {
		
		return null;
	}

	

	public Donar addDonar(Donar donar) {
		return donarRepository.save(donar);
	}

	public void deleteDonar(Integer donarId) {
		donarRepository.deleteById(donarId);
		
	}

	public Donar updateDonar(Donar donar, Integer donarId) {
		Optional<Donar> donarData = donarRepository.findById(donarId);
		if (donarData.isPresent()) {
			donar.setDonarId(donar.getDonarId());
			donar.setDonarName(donar.getDonarName());
			donar.setEmail(donar.getEmail());
			donar.setPassword(donar.getPassword());
			donar.setPhone(donar.getPhone());
			donar.setUsername(donar.getUsername());
			return donarRepository.save(donar);
		}else {
				return null;
			}
	}
}
