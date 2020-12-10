package hu.unideb.webdev.spring_data.service;

import hu.unideb.webdev.spring_data.exception.UnknownFilmException;
import hu.unideb.webdev.spring_data.exception.UnknownLanguageException;
import hu.unideb.webdev.spring_data.model.Film;

import java.util.Collection;

public interface FilmService {
    Collection<Film> getAllFilm();

    void recordFilm(Film film) throws UnknownLanguageException;
    void deleteFilm(Film film) throws UnknownFilmException;
}
