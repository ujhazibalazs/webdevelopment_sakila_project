package hu.unideb.webdev.spring_data.service;

import hu.unideb.webdev.spring_data.dao.FilmDao;
import hu.unideb.webdev.spring_data.exception.UnknownFilmException;
import hu.unideb.webdev.spring_data.exception.UnknownLanguageException;
import hu.unideb.webdev.spring_data.model.Film;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@Service
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService {

    private final FilmDao filmDao;

    @Override
    public Collection<Film> getAllFilm() {
        return filmDao.readAllFilm();
    }

    @Override
    public void recordFilm(Film film) throws UnknownLanguageException {
        filmDao.createFilm(film);
    }

    @Override
    public void deleteFilm(Film film) throws UnknownFilmException {
        filmDao.deleteFilm(film);
    }

}
