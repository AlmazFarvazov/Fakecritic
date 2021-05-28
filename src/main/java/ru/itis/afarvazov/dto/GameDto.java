package ru.itis.afarvazov.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.afarvazov.models.Corporation;
import ru.itis.afarvazov.models.Game;
import ru.itis.afarvazov.models.Genre;
import ru.itis.afarvazov.models.Media;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GameDto {

    private String title;
    private String summary;
    private LocalDate releaseDate;
    private Byte score;
    private Corporation developer;
    private List<Media> screens;
    private Media logo;
    private List<Genre> genres;

    public static GameDto from(Game game) {
        return GameDto.builder()
                .title(game.getTitle())
                .summary(game.getSummary())
                .releaseDate(game.getReleaseDate())
                .score(game.getScore())
                .developer(game.getDeveloper())
                .screens(game.getScreens())
                .logo(game.getLogo())
                .genres(game.getGenres())
                .build();
    }

    public static List<GameDto> from(List<Game> games) {
        return games.stream()
                .map(GameDto::from)
                .collect(Collectors.toList());
    }

}
