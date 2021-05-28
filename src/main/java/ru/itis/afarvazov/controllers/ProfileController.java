package ru.itis.afarvazov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.afarvazov.dto.GenreDto;
import ru.itis.afarvazov.dto.UserDto;
import ru.itis.afarvazov.security.details.UserDetailsImpl;
import ru.itis.afarvazov.services.GenresService;
import ru.itis.afarvazov.services.UsersService;

@Controller
public class ProfileController {


    private final GenresService genresService;
    private final UsersService usersService;

    @Autowired
    public ProfileController(UsersService usersService, GenresService genresService) {
        this.usersService = usersService;
        this.genresService = genresService;
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/profile")
    public String getProfilePage(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        model.addAttribute("genres", GenreDto.from(genresService.getAllGenres()));
        model.addAttribute("account", UserDto.from(userDetails.getUser()));
        return "profile_page";
    }

}
