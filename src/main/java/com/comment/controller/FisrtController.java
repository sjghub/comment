package com.comment.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FisrtController {
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("name","성준");
        return "greetings";
    }

}
