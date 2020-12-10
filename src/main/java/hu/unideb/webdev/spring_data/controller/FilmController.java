package hu.unideb.webdev.spring_data.controller;

import hu.unideb.webdev.spring_data.controller.dto.FilmDeleteRequestDto;
import hu.unideb.webdev.spring_data.controller.dto.FilmDto;
import hu.unideb.webdev.spring_data.controller.dto.FilmRecordRequestDto;
import hu.unideb.webdev.spring_data.exception.UnknownFilmException;
import hu.unideb.webdev.spring_data.exception.UnknownLanguageException;
import hu.unideb.webdev.spring_data.model.Film;
import hu.unideb.webdev.spring_data.service.FilmService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
public class FilmController {

    private final FilmService filmService;

    @GetMapping("/film")
    public Collection<FilmDto> listFilms() {
        return filmService.getAllFilm()
                .stream()
                .map(model -> FilmDto.builder()
                        .title(model.getTitle())
                        .description(model.getDescription())
                        .releaseYear(model.getReleaseYear())
                        .rentalDuration(model.getRentalDuration())
                        .rentalRate(model.getRentalRate())
                        .length(model.getLength())
                        .replacementCost(model.getReplacementCost())
                        .rating(model.getRating())
                        .specialFeatures(model.getSpecialFeatures())
                        .language(model.getLanguage())
                        .build())
                .collect(Collectors.toList());
    }

    @PostMapping("/film")
    public void recordFilm(@RequestBody FilmRecordRequestDto filmRecordRequestDto) {
        try {
            filmService.recordFilm(new Film(
                    filmRecordRequestDto.getTitle(),
                    filmRecordRequestDto.getDescription(),
                    filmRecordRequestDto.getReleaseYear(),
                    filmRecordRequestDto.getRentalDuration(),
                    filmRecordRequestDto.getRentalRate(),
                    filmRecordRequestDto.getLength(),
                    filmRecordRequestDto.getReplacementCost(),
                    filmRecordRequestDto.getRating(),
                    filmRecordRequestDto.getSpecialFeatures(),
                    filmRecordRequestDto.getLanguage()
            ));
        } catch (UnknownLanguageException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/film")
    public void deleteFilm(@RequestBody FilmDeleteRequestDto filmDeleteRequestDto) {
        try {
            filmService.deleteFilm(new Film(
                    filmDeleteRequestDto.getTitle(),
                    filmDeleteRequestDto.getDescription(),
                    filmDeleteRequestDto.getReleaseYear(),
                    filmDeleteRequestDto.getRentalDuration(),
                    filmDeleteRequestDto.getRentalRate(),
                    filmDeleteRequestDto.getLength(),
                    filmDeleteRequestDto.getReplacementCost(),
                    filmDeleteRequestDto.getRating(),
                    filmDeleteRequestDto.getSpecialFeatures(),
                    filmDeleteRequestDto.getLanguage()
            ));
        } catch (UnknownFilmException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
