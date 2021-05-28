package ru.itis.afarvazov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import ru.itis.afarvazov.dto.UserDto;
import ru.itis.afarvazov.dto.UserSignInForm;
import ru.itis.afarvazov.exceptions.NoSuchUserException;
import ru.itis.afarvazov.exceptions.WrongEmailOrPasswordException;
import ru.itis.afarvazov.services.UsersService;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;


@Controller
public class SignInController {

    private final UsersService usersService;

    @Autowired
    public SignInController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PermitAll
    @GetMapping(value = "/signIn")
    public String getSignInPage(Model model) {
        model.addAttribute("userForm", new UserSignInForm());
        return "sign_in_page";
    }

    @PermitAll
    @PostMapping(value = "/signIn")
    public RedirectView signIn(Model model, @Valid UserSignInForm userForm) {
        try {
            usersService.signIn(userForm);
            model.addAttribute("user", UserDto.from(usersService.getUserByEmail(userForm.getEmail())));
            return new RedirectView("/profile");
        } catch (WrongEmailOrPasswordException e) {
            model.addAttribute("errorMessage", e.getMessage());
        } catch (NoSuchUserException e) {
            model.addAttribute("errorMessage", e.getMessage());
        }
        return new RedirectView("/signIn");
    }

}
