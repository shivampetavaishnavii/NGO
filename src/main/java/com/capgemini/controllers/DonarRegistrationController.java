package com.capgemini.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.capgemini.model.Donar;
import com.capgemini.service.DonarService;

@Controller
@RequestMapping("/donarregistration")
public class DonarRegistrationController {
	
	private DonarService donarService;

    public DonarRegistrationController(DonarService donarService) {
        super();
        this.donarService = donarService;
    }


    @ModelAttribute("donar")
    public Donar DonarDto()
    {
        return new Donar();
    }

    @GetMapping
    public String showRegistrationForm()
    {
        return "donarregistration";
    }

    @PostMapping
    public String createDonar(@ModelAttribute("donar") Donar donar)
    {
        donarService.save(donar);
        return "redirect:/donarregistration?donarsuccess";
    }



}
