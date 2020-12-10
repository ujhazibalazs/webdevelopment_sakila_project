package hu.unideb.webdev.spring_data.service;

import hu.unideb.webdev.spring_data.exception.UnknownCategoryException;
import hu.unideb.webdev.spring_data.model.Category;

import java.util.Collection;

public interface CategoryService {

    Collection<Category> getAllCategory();

    void recordCategory(Category category);
    void deleteCategory(Category category) throws UnknownCategoryException;

}
