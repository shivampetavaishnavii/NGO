package com.capgemini.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//import com.capgemini.model.Donar;
import com.capgemini.model.NeedyPeople;
//import com.capgemini.service.DonarService;
import com.capgemini.service.NeedyPeopleService;

@Controller
@RequestMapping("/needypeopleregistration")
public class NeedyPeopleUserRegistration {
	
	private NeedyPeopleService needypeopleService;

    public NeedyPeopleUserRegistration(NeedyPeopleService needypeopleService) {
        super();
        this.needypeopleService = needypeopleService;
    }


    @ModelAttribute("needypeople")
    public NeedyPeople NeedyPeopleDto()
    {
        return new NeedyPeople();
    }

    @GetMapping
    public String showRegistrationForm()
    {
        return "needypeopleregistration";
    }

    @PostMapping
    public String createNeedyPeople(@ModelAttribute("needypeople") NeedyPeople needypeople)
    {
        needypeopleService.save(needypeople);
        return "redirect:/needypeopleregistration?needypeoplesuccess";
    }



}
