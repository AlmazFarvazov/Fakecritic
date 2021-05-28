package ru.itis.afarvazov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import ru.itis.afarvazov.dto.UserSignUpForm;
import ru.itis.afarvazov.exceptions.UserAlreadyExistException;
import ru.itis.afarvazov.services.UsersService;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;
import java.util.Objects;

@Controller
public class SignUpController {

    private final UsersService usersService;

    @Autowired
    public SignUpController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PermitAll
    @GetMapping(value = "/signUp")
    public String getSignUpPage(Model model) {
        model.addAttribute("userForm", new UserSignUpForm());
        return "sign_up_page";
    }

    @PermitAll
    @PostMapping(value = "/signUp")
    public RedirectView signUp(@Valid UserSignUpForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().stream().anyMatch(error -> {
                if (Objects.requireNonNull(error.getCodes())[0].equals("userForm.ValidNames")) {
                    model.addAttribute("errorMessage", error.getDefaultMessage());
                }
                return true;
            });
            model.addAttribute("userForm", form);
            return new RedirectView("/signUp");
        }
        try {
            usersService.signUp(form);
        } catch (UserAlreadyExistException e) {
            model.addAttribute("errorsMessage", e.getMessage());
        }
        return new RedirectView("/signIn");
    }

}
