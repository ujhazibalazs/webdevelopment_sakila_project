package hu.unideb.webdev.spring_data.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class FilmActorId implements Serializable {

    private int actorId;
    private int filmId;

}
