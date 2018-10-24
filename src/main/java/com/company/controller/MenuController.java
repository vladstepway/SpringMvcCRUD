package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MenuController {
    @RequestMapping(value = "/")
    public ModelAndView menu() {
        return new ModelAndView("menu");
    }
}
