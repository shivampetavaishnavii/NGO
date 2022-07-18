package com.capgemini.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.capgemini.model.Donar;
import com.capgemini.model.User;
//import com.capgemini.service.DonarService;
import com.capgemini.service.UserService;

@RestController
@RequestMapping({"/userAdmin"})
public class UserController {
	
	 @Autowired
	    private UserService userService;

	    @GetMapping(path = {"/all"})
	    public List<User> getUserAdmin() {
	        return userService.findAll();
	    }

	    @DeleteMapping(path = {"/{id}"})
	    public User delete(@PathVariable("id") int id) {
	        User deletedUser = null;
	        return deletedUser;
	    }
	    @GetMapping
	    public String showRegistrationForm() {
	        return "adminregistration";
	    }

	    @PostMapping
	    public String registerUserAccount(@ModelAttribute User user, BindingResult result, Model model) {
	        if(result.hasErrors()){
	            System.out.println("There was a error "+result);
	            System.out.println("Person is: "+ user.getUsername());
	        }

	        model.addAttribute("person", user);

	        userService.save(user);
	        return "redirect:/adminregistration?adminsuccess";
	    }


	    @PostMapping(path = {"/create"})
	    public void create(@RequestBody User user) {
	        userService.save(user);

	    }


}
