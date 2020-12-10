package hu.unideb.webdev.spring_data.exception;

import hu.unideb.webdev.spring_data.model.Category;
import hu.unideb.webdev.spring_data.model.Film;

public class UnknownFilmException extends Exception {

    private Film film;

    public UnknownFilmException(Film film) {
        this.film = film;
    }

    public UnknownFilmException(String message) {
        super(message);
    }

}
