package com.capgemini.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.capgemini.model.Donar;
import com.capgemini.service.DonarService;

@Controller
public class DonarMainController {


    @Autowired
    private DonarService donarService;

    @GetMapping("/login1")
    public String login() {
        return "donarlogin";
    }

    @GetMapping("//")
    public String home() {
        return "donarindex";
    }


    //Check for Credentials
    @PostMapping("/login1")
    public String login(@ModelAttribute(name = "loginForm") Donar login, Model m) {
        String uname = login.getUsername();
        String pass = login.getPassword();
        Donar donar = donarService.checkUserNamePassword(uname, pass);
        if (donar !=null) {
            m.addAttribute("uname", uname);
            m.addAttribute("pass", pass);
            return "donarindex";
        }
        m.addAttribute("error", "Incorrect Username & Password");
        return "donarlogin";

    }
}
