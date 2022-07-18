package com.capgemini.controllers;

import java.util.ArrayList;

import java.util.List;

import com.capgemini.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.capgemini.model.Employee;



//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("employees")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/create")
   public List<Employee> getEmployees() {
        return adminService.findAll();
    }
    @GetMapping("/employee/id")
    public Employee getEmployeeById(@PathVariable("id") Integer id) {
    	return adminService.getEmployeeById(id);
    }

    @PostMapping("/addemployee")
	public Employee addEmployee(@RequestBody Employee employee){
		return  adminService.addEmployee(employee);
	}
    @DeleteMapping("/deleteemployee/{id}")
	public void deleteEmployee(@PathVariable("id") Integer employeeId){
		adminService.deleteEmployee(employeeId);
	}
    
    @PutMapping("/updateemployee/{id}")
	public Employee updateEmployee(@RequestBody Employee employee, @PathVariable("id") Integer employeeId){
		Employee employeeData = adminService.updateEmployee(employee, employeeId);
		return employeeData;
	}
    
    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute Employee employee, BindingResult result, Model model) {
        if(result.hasErrors()){
            System.out.println("There was a error "+result);
            System.out.println("Person is: "+ employee.getEmail());
        }

        model.addAttribute("person", employee);

        adminService.save(employee);
        return "redirect:/registration?success";
    }    
}