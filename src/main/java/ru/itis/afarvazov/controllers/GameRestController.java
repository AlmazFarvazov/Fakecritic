package ru.itis.afarvazov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.afarvazov.dto.GameDto;
import ru.itis.afarvazov.services.GamesService;
import ru.itis.afarvazov.services.GenresService;

import javax.annotation.security.PermitAll;
import java.util.List;


@RestController
public class GameRestController {

    private final GamesService gamesService;
    private final GenresService genresService;

    @Autowired
    public GameRestController(GamesService gamesService, GenresService genresService) {
        this.gamesService = gamesService;
        this.genresService = genresService;
    }

    @PermitAll
    @GetMapping(value = "/games/{page}/{size}")
    public ResponseEntity<List<GameDto>> getGameForPage(@PathVariable int page, @PathVariable int size) {
        return ResponseEntity.ok(GameDto.from(gamesService.getGamesWithPages(page, size)));
    }

    @PermitAll
    @GetMapping(value = "/games")
    public ResponseEntity<List<GameDto>> getGames() {
        return ResponseEntity.ok(GameDto.from(gamesService.getAll()));
    }

    @PermitAll
    @GetMapping(value = "/games/{genre}/{page}/{size}")
    public ResponseEntity<List<GameDto>> getGameForPageByGenre(@PathVariable String genre,
                                                             @PathVariable int page, @PathVariable int size) {
        return ResponseEntity.ok(GameDto.from(gamesService.getGamesWithPagesForGenre(genre, page, size)));
    }

    @PermitAll
    @GetMapping(value = "/games/{genre}")
    public ResponseEntity<List<GameDto>> getGamesByGenre(@PathVariable String genre) {
        return ResponseEntity.ok(GameDto.from(gamesService.getAllByGenre(genresService.getByName(genre))));
    }

}
