package ru.itis.afarvazov.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.afarvazov.exceptions.NoSuchGenreException;
import ru.itis.afarvazov.models.Genre;
import ru.itis.afarvazov.repositories.GenresRepository;

import java.util.List;

@Service
public class GenresServiceImpl implements GenresService {

    private final GenresRepository genresRepository;

    @Autowired
    public GenresServiceImpl(GenresRepository genresRepository) {
        this.genresRepository = genresRepository;
    }

    @Override
    public Genre getByName(String genreName) {
        return genresRepository.findGenreByName(genreName).orElseThrow(NoSuchGenreException::new);
    }

    @Override
    public List<Genre> getAllGenres() {
        return genresRepository.findAll();
    }
}
