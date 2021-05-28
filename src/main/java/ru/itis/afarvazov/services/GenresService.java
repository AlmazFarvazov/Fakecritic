package ru.itis.afarvazov.services;

import ru.itis.afarvazov.models.Genre;

import java.util.List;

public interface GenresService {

    List<Genre> getAllGenres();
    Genre getByName(String genreName);

}
