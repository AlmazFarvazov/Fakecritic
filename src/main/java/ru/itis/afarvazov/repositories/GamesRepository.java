package ru.itis.afarvazov.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.afarvazov.models.Corporation;
import ru.itis.afarvazov.models.Game;
import ru.itis.afarvazov.models.Genre;

import java.util.List;
import java.util.Optional;

public interface GamesRepository extends JpaRepository<Game, Long> {

    List<Game> findAllByDeveloperOrderByTitle(Corporation developer);
    List<Game> findAllByGenresOrderByTitle(Genre genre);
    List<Game> findAllByTitleIsContaining(String string);
    Optional<Game> findGameByTitle(String title);

}
