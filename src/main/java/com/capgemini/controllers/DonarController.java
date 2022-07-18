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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.model.Donar;

import com.capgemini.service.DonarService;

@RestController
@RequestMapping({"/donars"})
public class DonarController {
	
	 @Autowired
	    private DonarService donarService;

	    @GetMapping(path = {"/create"})
	    public List<Donar> getDonars() {
	        return donarService.findAll();
	    }
	    @GetMapping("/donar/id")
	    public Donar getDonarById(@PathVariable("id") Integer id) {
	    	return donarService.getDonarById(id);
	    }

	    @PostMapping("/adddonar")
		public Donar addDonar(@RequestBody Donar donar){
			return  donarService.addDonar(donar);
		}
	    @DeleteMapping("/deletedonar/{id}")
		public void deleteDonar(@PathVariable("id") Integer donarId){
			donarService.deleteDonar(donarId);
		}
	    
	    @PutMapping("/updatedonar/{id}")
		public Donar updateDonar(@RequestBody Donar donar, @PathVariable("id") Integer donarId){
			Donar donarData = ( donarService.updateDonar(donar, donarId));
			return donarData;
		}
	   
	    @GetMapping
	    public String showRegistrationForm() {
	        return "donarregistration";
	    }

	    @PostMapping
	    public String registerUserAccount(@ModelAttribute Donar donar, BindingResult result, Model model) {
	        if(result.hasErrors()){
	            System.out.println("There was a error "+result);
	            System.out.println("Person is: "+ donar.getEmail());
	        }

	        model.addAttribute("person", donar);

	        donarService.save(donar);
	        return "redirect:/donarregistration?donarsuccess";
	    }



}
