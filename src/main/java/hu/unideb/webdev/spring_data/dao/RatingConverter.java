package hu.unideb.webdev.spring_data.dao;

import javax.persistence.AttributeConverter;
import java.util.stream.Stream;

public class RatingConverter implements AttributeConverter<Rating, String> {

    @Override
    public String convertToDatabaseColumn(Rating rating) {
        if (rating == null) {
            return null;
        }
        return rating.getS();
    }

    @Override
    public Rating convertToEntityAttribute(String s) {
        if (s == null) {
            return null;
        }
        return Stream.of(Rating.values())
                .filter(rating -> rating.getS().equals(s))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
