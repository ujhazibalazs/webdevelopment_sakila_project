package hu.unideb.webdev.spring_data.dao.entity;

import hu.unideb.webdev.spring_data.dao.FilmCategoryId;
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
@Table(name = "film_category")
public class FilmCategoryEntity {

    @EmbeddedId
    private FilmCategoryId id;

    @ManyToOne
    @MapsId("filmId")
    @JoinColumn(name = "film_id")
    private FilmEntity filmEntity;

    @ManyToOne
    @MapsId("categoryId")
    @JoinColumn(name = "category_id")
    private CategoryEntity categoryEntity;

    @Column(name = "last_update")
    private Timestamp lastUpdate;

}
