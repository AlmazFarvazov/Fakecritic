package ru.itis.afarvazov.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.afarvazov.models.Corporation;
import ru.itis.afarvazov.models.Game;
import ru.itis.afarvazov.models.Genre;
import ru.itis.afarvazov.repositories.GamesRepository;

import java.util.List;

@Service
public class GamesServiceImpl implements GamesService {

    private final GamesRepository gamesRepository;

    @Autowired
    public GamesServiceImpl(GamesRepository gamesRepository) {
        this.gamesRepository = gamesRepository;
    }

    @Override
    public Game getGameByTitle(String title) {
        return gamesRepository.findGameByTitle(title).orElseThrow(IllegalAccessError::new);
    }

    @Override
    public List<Game> getAll() {
        return gamesRepository.findAll();
    }

    @Override
    public List<Game> getAllByGenre(Genre genre) {
        return gamesRepository.findAllByGenresOrderByTitle(genre);
    }

    @Override
    public List<Game> getAllByDeveloper(Corporation corporation) {
        return gamesRepository.findAllByDeveloperOrderByTitle(corporation);
    }
}
