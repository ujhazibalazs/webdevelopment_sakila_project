package hu.unideb.webdev.spring_data.dao;

import hu.unideb.webdev.spring_data.dao.entity.LanguageEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface LanguageRepository extends CrudRepository<LanguageEntity, Integer> {
    Collection<LanguageEntity> findByName(String name);
}
