package ru.itis.afarvazov.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.afarvazov.models.Genre;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GenreDto {
    private String name;
    private List<GameDto> games;

    public static GenreDto from(Genre genre) {
        return GenreDto.builder()
                .name(genre.getName())
                .games(GameDto.from(genre.getGames()))
                .build();
    }

    public static List<GenreDto> from(List<Genre> genres) {
        return genres.stream()
                .map(GenreDto::from)
                .collect(Collectors.toList());
    }

}
