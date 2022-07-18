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

import com.capgemini.model.Employee;
import com.capgemini.model.NeedyPeople;
import com.capgemini.service.NeedyPeopleService;


@RestController
@RequestMapping({"/needypeoples"})
public class NeedyPeopleController {
    
	 @Autowired
	    private NeedyPeopleService needypeopleService;

	    @GetMapping("/create")
	    public List<NeedyPeople> getDonars() {
	        return needypeopleService.findAll();
	    }
	    @GetMapping("/needypeople/id")
	    public NeedyPeople getNeedyById(@PathVariable("id") Integer id) {
	    	return needypeopleService.getNeedyById(id);
	    }

	    @PostMapping("/addneedypeople")
		public NeedyPeople addNeedyPeople(@RequestBody NeedyPeople needypeople){
			return  needypeopleService.addNeedyPeople(needypeople);
		}
	    @DeleteMapping("/deleteneedypeople/{id}")
		public void deleteNeedyPeople(@PathVariable("id") Integer needypersonId){
			needypeopleService.deleteNeedyPeople(needypersonId);
		}
	    
	    @PutMapping("/updateneedypeople/{id}")
		public NeedyPeople updateNeedyPeople(@RequestBody NeedyPeople needypeople, @PathVariable("id") Integer needypersonId){
			NeedyPeople needypeopleData = needypeopleService.updateNeedyPeople(needypeople, needypersonId);
			return needypeopleData;
		}
	        

	    @GetMapping
	    public String showRegistrationForm() {
	        return "needypeopleregistration";
	    }

	    @PostMapping
	    public String registerUserAccount(@ModelAttribute NeedyPeople needypeople, BindingResult result, Model model) {
	        if(result.hasErrors()){
	            System.out.println("There was a error "+result);
	            System.out.println("Person is: "+ needypeople.getEmail());
	        }

	        model.addAttribute("person", needypeople);

	        needypeopleService.save(needypeople);
	        return "redirect:/needypeopleregistration?needypeoplesuccess";
	    }


	   

}
