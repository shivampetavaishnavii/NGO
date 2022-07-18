package com.capgemini.controllers;

import com.capgemini.model.Employee;
import com.capgemini.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }


    //Check for Credentials
    @PostMapping("/login")
    public String login(@ModelAttribute(name = "loginForm") Employee login, Model m) {
        String uname = login.getUsername();
        String pass = login.getPassword();
        Employee employee = adminService.checkUserNamePassword(uname, pass);
        if (employee !=null) {
            m.addAttribute("uname", uname);
            m.addAttribute("pass", pass);
            return "index";
        }
        m.addAttribute("error", "Incorrect Username & Password");
        return "login";

    }
}
