package com.codegym.controller;

import com.codegym.model.Login;
import com.codegym.model.User;
import com.codegym.service.IUserDao;
import com.codegym.service.UserDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {
    private static UserDao userDao = new UserDao();
    @GetMapping ("/home")
public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("login",new Login());
        return modelAndView;
    }
    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute Login login){
        User user = userDao.checkLogin(login);
        if (user==null){
            ModelAndView modelAndView = new ModelAndView("ERROR");
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("user");
            modelAndView.addObject("user",user);
            return modelAndView;
        }
    }
}
