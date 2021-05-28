package ru.itis.afarvazov.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.security.PermitAll;

@Controller
@RequestMapping("/")
public class RootController {
    @PermitAll
    @GetMapping
    public RedirectView getRoot(Authentication authentication) {
        if (authentication != null) {
            return new RedirectView("/profile");
        } else {
            return new RedirectView("/signIn");
        }
    }
}

