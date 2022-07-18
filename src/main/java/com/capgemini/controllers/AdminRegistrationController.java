package com.capgemini.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//import com.capgemini.model.Donar;
import com.capgemini.model.User;
//import com.capgemini.service.DonarService;
import com.capgemini.service.UserService;

@Controller
@RequestMapping("/adminregistration")
public class AdminRegistrationController {
	
	private UserService userService;

    public AdminRegistrationController(UserService userService) {
        super();
        this.userService = userService;
    }


    @ModelAttribute("user")
    public User UserDto()
    {
        return new User();
    }

    @GetMapping
    public String showRegistrationForm()
    {
        return "adminregistration";
    }

    @PostMapping
    public String createUser(@ModelAttribute("user") User user)
    {
        userService.save(user);
        return "redirect:/adminregistration?adminsuccess";
    }



}
