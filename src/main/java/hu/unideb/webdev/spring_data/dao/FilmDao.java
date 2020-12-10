package hu.unideb.webdev.spring_data.dao;

import hu.unideb.webdev.spring_data.exception.UnknownActorException;
import hu.unideb.webdev.spring_data.exception.UnknownFilmException;
import hu.unideb.webdev.spring_data.exception.UnknownLanguageException;
import hu.unideb.webdev.spring_data.model.Actor;
import hu.unideb.webdev.spring_data.model.Film;

import java.util.Collection;

public interface FilmDao {

    void createFilm(Film film) throws UnknownLanguageException;
    Collection<Film> readAllFilm();
    void updateFilm(Film original, Film updated);
    void deleteFilm(Film film) throws UnknownFilmException;

}
