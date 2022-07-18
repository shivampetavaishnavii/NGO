package com.capgemini.service;



import com.capgemini.dao.EmployeeDao;

import com.capgemini.model.Employee;


import com.capgemini.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminService implements EmployeeDao<Employee, Integer> {
    @Autowired
    private AdminRepository adminRepository;
       
    @Override
    public Employee save(Employee employee) {
        employee = adminRepository.save(employee);
        return employee;
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = (List<Employee>) adminRepository.findAll();
        return employees;
    }
    public Employee checkUserNamePassword(String userName,String password){
        Employee employee=adminRepository.findByUsernameAndPassword(userName,password);
        return employee;
    }

	
	public Employee addEmployee(Employee employee) {
		
		return adminRepository.save(employee);
	}

	public void deleteEmployee(Integer employeeId) {

		adminRepository.deleteById(employeeId);
	}

	public Employee updateEmployee(Employee employee, Integer employeeId) {
	
		Optional<Employee> employeeData = adminRepository.findById(employeeId);
		if (employeeData.isPresent()) {
			employee.setEmployeeId(employee.getEmployeeId());
			employee.setEmployeeName(employee.getEmployeeName());
			employee.setEmail(employee.getEmail());
			employee.setPassword(employee.getPassword());
			employee.setPhone(employee.getPhone());
			employee.setUsername(employee.getUsername());
			return adminRepository.save(employee);
		}else {
				return null;
			}
	}

	public Employee getEmployeeById(Integer id) {
		return null;
	}

  
}
