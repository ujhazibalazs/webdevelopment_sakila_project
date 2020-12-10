package hu.unideb.webdev.spring_data.dao;

import hu.unideb.webdev.spring_data.dao.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<CategoryEntity, Integer> {
}
