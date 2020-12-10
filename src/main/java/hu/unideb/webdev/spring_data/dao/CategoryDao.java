package hu.unideb.webdev.spring_data.dao;

import hu.unideb.webdev.spring_data.exception.UnknownCategoryException;
import hu.unideb.webdev.spring_data.model.Category;

import java.util.Collection;

public interface CategoryDao {

    void createCategory(Category category);
    Collection<Category> readAllCategory();
    void updateCategory(Category original, Category updated);
    void deleteCategory(Category category) throws UnknownCategoryException;

}
