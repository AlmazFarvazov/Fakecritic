package ru.itis.afarvazov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.itis.afarvazov.dto.GameDto;
import ru.itis.afarvazov.dto.GenreDto;
import ru.itis.afarvazov.services.GamesService;
import ru.itis.afarvazov.services.GenresService;

import javax.annotation.security.PermitAll;


@Controller
public class GameRestController {

    private final GenresService genresService;
    private final GamesService gamesService;

    @Autowired
    public GameRestController(GenresService genresService, GamesService gamesService) {
        this.genresService = genresService;
        this.gamesService = gamesService;
    }

    @PermitAll
    @GetMapping(value = "/games")
    public String getGamePage(Model model) {
        model.addAttribute("genres", GenreDto.from(genresService.getAllGenres()));
        model.addAttribute("games", GameDto.from(gamesService.getAll()));
        return "games_page";
    }

    @PermitAll
    @GetMapping(value = "/games/{genre}")
    public String getGamePageForGenre(Model model, @PathVariable String genre) {
        model.addAttribute("genres", GenreDto.from(genresService.getAllGenres()));
        model.addAttribute("games", GameDto.from(gamesService.getAllByGenre(genresService.getByName(genre))));
        return "games_page";
    }

}
