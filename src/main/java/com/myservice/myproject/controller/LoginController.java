package com.myservice.myproject.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@Controller("/")
public class LoginController {

    @GetMapping("home")
    public String homePagge(HttpSession session){
        if(session.getAttribute("userName")!= null){
            System.out.println("name: " +session.getAttribute("userName"));
        }

        return "/index.html";
    }

    @GetMapping("/login")
    public String loginPage(String message, String error, String logout, Model model){
        if(error != null){
            model.addAttribute("error", "Invalid User name or Password");
        }
        if(logout != null){
            message = "You have been logged out successfully";
        }
//        List<Role> roles = roleDao.findAll();
//        moduleController.multiChoiceFormModule(model,"user_login",new User(), "/login", roles, message);
        return "html/index.html";
//        return "user_login";
    }

}
