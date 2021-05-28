package ru.itis.afarvazov.services;

import ru.itis.afarvazov.models.Corporation;
import ru.itis.afarvazov.models.Game;
import ru.itis.afarvazov.models.Genre;

import java.util.List;

public interface GamesService {

    List<Game> getAllByGenre(Genre genre);
    List<Game> getAllByDeveloper(Corporation corporation);
    List<Game> getAll();
    Game getGameByTitle(String title);
    List<Game> getGamesWithPages(int page, int size);
    List<Game> getGamesWithPagesForGenre(String genre, int page, int size);

}
