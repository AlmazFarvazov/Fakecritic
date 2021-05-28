package ru.itis.afarvazov.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Query(nativeQuery = true,
            value = "select * from game order by id limit :limit offset :offset ;")
    List<Game> findAllByPage(@Param("limit") int limit, @Param("offset") int offset);

    @Query(nativeQuery = true,
            value = "WITH A as(\n" +
                    "    SELECT * from game left join game_genre gg on game.id = gg.game_id\n" +
                    ") select game_id as id, release_date, score, summary, title, corporation_id, logo from A" +
                    " left join genre on A.genre_id = genre.id where genre.name = :genre limit :limit offset :offset")
    List<Game> findAllByPageAndGenre(@Param("genre") String genre, @Param("limit") int limit, @Param("offset") int offset);

}
