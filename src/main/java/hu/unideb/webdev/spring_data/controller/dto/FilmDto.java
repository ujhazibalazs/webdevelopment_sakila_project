package hu.unideb.webdev.spring_data.controller.dto;

import hu.unideb.webdev.spring_data.dao.Rating;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.sql.Date;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class FilmDto {

    private String title;
    private String description;
    private int releaseYear;
    private int rentalDuration;
    private double rentalRate;
    private int length;
    private double replacementCost;
    private Rating rating;
    private String specialFeatures;
    private String language;

}
