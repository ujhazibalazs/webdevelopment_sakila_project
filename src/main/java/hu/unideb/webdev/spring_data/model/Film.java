package hu.unideb.webdev.spring_data.model;

import hu.unideb.webdev.spring_data.dao.Rating;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.sql.Date;

@AllArgsConstructor
@ToString
@Getter
@EqualsAndHashCode
public class Film {

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
