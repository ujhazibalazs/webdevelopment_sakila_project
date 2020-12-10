package hu.unideb.webdev.spring_data.dao.entity;

import hu.unideb.webdev.spring_data.dao.Rating;
import hu.unideb.webdev.spring_data.dao.RatingConverter;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "film")

public class FilmEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private int filmId;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private LanguageEntity languageEntity;

    @ManyToOne
    @JoinColumn(name = "original_language_id")
    private LanguageEntity originalLanguageEntity;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "release_year")
    private int releaseYear;

    @Column(name = "rental_duration")
    private int rentalDuration;

    @Column(name = "rental_rate")
    private double rentalRate;

    @Column(name = "length")
    private int length;

    @Column(name = "replacement_cost")
    private double replacementCost;

    @Column(name = "rating")
    @Convert(converter = RatingConverter.class)
    private Rating rating;

    @Column(name = "special_features")
    private String specialFeatures;

    @Column(name = "last_update")
    private Timestamp lastUpdate;

}
