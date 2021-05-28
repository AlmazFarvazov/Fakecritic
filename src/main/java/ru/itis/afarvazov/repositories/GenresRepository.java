package ru.itis.afarvazov.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.afarvazov.models.Game;
import ru.itis.afarvazov.models.Genre;

import java.util.List;
import java.util.Optional;

public interface GenresRepository extends JpaRepository<Genre, Long> {

    List<Genre> findAllByGamesOrderByName(Game game);
    Optional<Genre> findGenreByName(String name);
}
