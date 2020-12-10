package hu.unideb.webdev.spring_data.dao;

import hu.unideb.webdev.spring_data.dao.entity.ActorEntity;
import hu.unideb.webdev.spring_data.dao.entity.CategoryEntity;
import hu.unideb.webdev.spring_data.exception.UnknownCategoryException;
import hu.unideb.webdev.spring_data.model.Category;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Slf4j
@RequiredArgsConstructor
public class CategoryDaoImpl implements CategoryDao {

    private final CategoryRepository categoryRepository;

    @Override
    public void createCategory(Category category) {
        CategoryEntity categoryEntity = null;
        categoryEntity = CategoryEntity.builder()
                .name(category.getName())
                .lastUpdate(new Timestamp((new Date()).getTime()))
                .build();
        categoryRepository.save(categoryEntity);
    }

    @Override
    public Collection<Category> readAllCategory() {
        return StreamSupport.stream(categoryRepository.findAll().spliterator(), false)
                .map(categoryEntity -> new Category(
                        categoryEntity.getName()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public void updateCategory(Category original, Category updated) {

    }

    @Override
    public void deleteCategory(Category category) throws UnknownCategoryException {
        Optional<CategoryEntity> categoryEntity = StreamSupport.stream(categoryRepository.findAll().spliterator(), false).filter(
                entity -> {
                    return category.getName().equals(entity.getName());
                }
        ).findAny();
        if(!categoryEntity.isPresent()) {
            throw new UnknownCategoryException(category);
        }
        categoryRepository.delete(categoryEntity.get());
    }

}
