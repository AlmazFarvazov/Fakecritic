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
public class GameController {

    private final GenresService genresService;
    private final GamesService gamesService;

    @Autowired
    public GameController(GamesService gamesService, GenresService genresService) {
        this.gamesService = gamesService;
        this.genresService = genresService;
    }

    @PermitAll
    @GetMapping(value = "/game/{game-name}")
    public String getGamePage(Model model, @PathVariable("game-name") String gameName) {
        GameDto gameDto = GameDto.from(gamesService.getGameByTitle(gameName));
        model.addAttribute("genres", GenreDto.from(genresService.getAllGenres()));
        model.addAttribute("gameGenres", gameDto.getGenres());
        model.addAttribute("game", gameDto);
        return "game_page";
    }

}
