package ru.itis.afarvazov.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.afarvazov.models.Corporation;
import ru.itis.afarvazov.models.Game;
import ru.itis.afarvazov.models.Genre;

import java.util.List;

public interface GamesRepository extends JpaRepository<Game, Long> {

    List<Game> findAllByDeveloper(Corporation developer);
    List<Game> findAllByGenres(Genre genre);

}
