package com.duing.controller;

import com.duing.domain.User;
import com.duing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(User user, Model model){
       if(userService.checkLogin(user)) return "toExam";
       model.addAttribute("flag",true);
       return "index";
    }
}
