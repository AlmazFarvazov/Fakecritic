package ru.itis.afarvazov.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.security.PermitAll;


@Controller
public class MainController {

    @PermitAll
    @GetMapping(value = "/news")
    public String getMainPage(Model model) {
        return "main_page";
    }

}
