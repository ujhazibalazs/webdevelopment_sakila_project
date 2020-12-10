package hu.unideb.webdev.spring_data.dao;

import hu.unideb.webdev.spring_data.dao.entity.FilmActorEntity;
import org.springframework.data.repository.CrudRepository;

public interface FilmCategoryRepository extends CrudRepository<FilmActorEntity, Integer> {
}
