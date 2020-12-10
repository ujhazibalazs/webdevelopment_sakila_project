package hu.unideb.webdev.spring_data.dao;

import hu.unideb.webdev.spring_data.dao.entity.FilmEntity;
import org.springframework.data.repository.CrudRepository;

public interface FilmRepository extends CrudRepository<FilmEntity, Integer> {



}
