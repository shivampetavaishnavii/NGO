package com.capgemini.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.capgemini.model.User;
import com.capgemini.service.UserService;

@Controller
public class UserMainController {


    @Autowired
    private UserService userService;

    @GetMapping("/login4")
    public String login() {
        return "adminlogin";
    }

    @GetMapping("//////")
    public String home() {
        return "adminindex";
    }


    //Check for Credentials
    @PostMapping("/login4")
    public String login(@ModelAttribute(name = "loginForm") User login, Model m) {
        String uname = login.getUsername();
        String pass = login.getPassword();
        User user= userService.checkUserNamePassword(uname, pass);
        if (user !=null) {
            m.addAttribute("uname", uname);
            m.addAttribute("pass", pass);
            return "adminindex";
        }
        m.addAttribute("error", "Incorrect Username & Password");
        return "adminlogin";

    }
}
