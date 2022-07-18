package com.capgemini.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.capgemini.model.NeedyPeople;
import com.capgemini.service.NeedyPeopleService;


@Controller
public class NeedyPeopleMainController {


    @Autowired
    private NeedyPeopleService needypeopleService;

    @GetMapping("/login2")
    public String login() {
        return "needypeoplelogin";
    }

    @GetMapping("////")
    public String home() {
        return "needypeopleindex";
    }


    //Check for Credentials
    @PostMapping("/login2")
    public String login(@ModelAttribute(name = "loginForm") NeedyPeople login, Model m) {
        String uname = login.getUsername();
        String pass = login.getPassword();
        NeedyPeople needypeople = needypeopleService.checkUserNamePassword(uname, pass);
        if (needypeople !=null) {
            m.addAttribute("uname", uname);
            m.addAttribute("pass", pass);
            return "needypeopleindex";
        }
        m.addAttribute("error", "Incorrect Username & Password");
        return "needypeoplelogin";

    }
}
