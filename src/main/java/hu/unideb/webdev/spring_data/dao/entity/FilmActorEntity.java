package hu.unideb.webdev.spring_data.dao.entity;

import hu.unideb.webdev.spring_data.dao.FilmActorId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "film_actor")
public class FilmActorEntity {

    @EmbeddedId
    private FilmActorId id;

    @ManyToOne
    @MapsId("actorId")
    @JoinColumn(name = "actor_id")
    private ActorEntity actorEntity;

    @ManyToOne
    @MapsId("filmId")
    @JoinColumn(name = "film_id")
    private FilmEntity filmEntity;

    @Column(name = "last_update")
    private Timestamp lastUpdate;

}
