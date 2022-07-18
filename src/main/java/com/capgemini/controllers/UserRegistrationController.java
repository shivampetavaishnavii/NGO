package com.capgemini.controllers;

import com.capgemini.model.Employee;
import com.capgemini.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/registration")
public class UserRegistrationController {


    private AdminService adminService;

    public UserRegistrationController(AdminService adminService) {
        super();
        this.adminService = adminService;
    }


    @ModelAttribute("employee")
    public Employee EmployeeDto()
    {
        return new Employee();
    }

    @GetMapping
    public String showRegistrationForm()
    {
        return "registration";
    }

    @PostMapping
    public String createEmployee(@ModelAttribute("employee") Employee employee)
    {
        adminService.save(employee);
        return "redirect:/registration?success";
    }


}
