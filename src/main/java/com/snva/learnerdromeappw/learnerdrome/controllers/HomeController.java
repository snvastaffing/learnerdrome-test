package com.snva.learnerdromeappw.learnerdrome.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
public class HomeController {

    //@RequestMapping(path = "/", method = RequestMethod.GET)
    @RequestMapping("/")
    public ModelAndView home(ModelMap modelMap){
        return new ModelAndView("home");
    }

    @RequestMapping("/home")
    public String home2(ModelMap modelMap){
        return "home";
    }

    @ResponseBody
    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public HashMap<String,String> home1(ModelMap modelMap){
        HashMap<String ,String> map = new HashMap<>();
        map.put("data","vale");
        return map;
    }






}
