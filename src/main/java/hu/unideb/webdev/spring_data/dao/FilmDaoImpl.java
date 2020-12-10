package hu.unideb.webdev.spring_data.dao;

import hu.unideb.webdev.spring_data.dao.entity.FilmEntity;
import hu.unideb.webdev.spring_data.dao.entity.LanguageEntity;
import hu.unideb.webdev.spring_data.exception.UnknownFilmException;
import hu.unideb.webdev.spring_data.exception.UnknownLanguageException;
import hu.unideb.webdev.spring_data.model.Film;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Slf4j
@RequiredArgsConstructor
public class FilmDaoImpl implements FilmDao {

    private final FilmRepository filmRepository;
    private final LanguageRepository languageRepository;

    @Override
    public void createFilm(Film film) throws UnknownLanguageException {

        FilmEntity filmEntity = null;
        Optional<LanguageEntity> languageEntity = languageRepository.findByName(film.getLanguage()).stream().findFirst();
        if(!languageEntity.isPresent()) {
            throw new UnknownLanguageException(film.getLanguage());
        }
        Optional<LanguageEntity> originalLanguageEntity = languageRepository.findByName(film.getLanguage()).stream().findFirst();
        if(!originalLanguageEntity.isPresent()) {
            throw new UnknownLanguageException(film.getLanguage());
        }

        filmEntity = FilmEntity.builder()
                .title(film.getTitle())
                .description(film.getDescription())
                .releaseYear(film.getReleaseYear())
                .rentalDuration(film.getRentalDuration())
                .rentalRate(film.getRentalRate())
                .length(film.getLength())
                .replacementCost(film.getReplacementCost())
                .rating(film.getRating())
                .specialFeatures(film.getSpecialFeatures())
                .languageEntity(languageEntity.get())
                .originalLanguageEntity(originalLanguageEntity.get())
                .lastUpdate(new Timestamp((new Date()).getTime()))
                .build();
        System.out.println(film.getReleaseYear());
        System.out.println(film.getSpecialFeatures());
        filmRepository.save(filmEntity);

    }

    @Override
    public Collection<Film> readAllFilm() {
        return StreamSupport.stream(filmRepository.findAll().spliterator(), false)
                .map(filmEntity -> new Film(
                        filmEntity.getTitle(),
                        filmEntity.getDescription(),
                        filmEntity.getReleaseYear(),
                        filmEntity.getRentalDuration(),
                        filmEntity.getRentalRate(),
                        filmEntity.getLength(),
                        filmEntity.getReplacementCost(),
                        filmEntity.getRating(),
                        filmEntity.getSpecialFeatures(),
                        filmEntity.getLanguageEntity().getName()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public void updateFilm(Film original, Film updated) {

    }

    @Override
    public void deleteFilm(Film film) throws UnknownFilmException {
        Optional<FilmEntity> filmEntity = StreamSupport.stream(filmRepository.findAll().spliterator(), false).filter(
                entity -> {
                    return film.getTitle().equals(entity.getTitle()) &&
                            film.getDescription().equals(entity.getDescription()) &&
                            film.getReleaseYear() == entity.getReleaseYear() &&
                            film.getRentalDuration() == entity.getRentalDuration() &&
                            film.getRentalRate() == entity.getRentalRate() &&
                            film.getLength() == entity.getLength() &&
                            film.getReplacementCost() == entity.getReplacementCost() &&
                            film.getRating().equals(entity.getRating()) &&
                            film.getSpecialFeatures().equals(entity.getSpecialFeatures()) &&
                            film.getLanguage().equals(entity.getLanguageEntity().getName());
                }
        ).findAny();
        if(!filmEntity.isPresent()) {
            throw new UnknownFilmException(film);
        }
        filmRepository.delete(filmEntity.get());
    }

}
