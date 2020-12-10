package hu.unideb.webdev.spring_data.service;

import hu.unideb.webdev.spring_data.dao.CategoryDao;
import hu.unideb.webdev.spring_data.exception.UnknownCategoryException;
import hu.unideb.webdev.spring_data.model.Category;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Slf4j
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryDao categoryDao;

    @Override
    public Collection<Category> getAllCategory() {
        return categoryDao.readAllCategory();
    }

    @Override
    public void recordCategory(Category category) {
        categoryDao.createCategory(category);
    }

    @Override
    public void deleteCategory(Category category) throws UnknownCategoryException {
        categoryDao.deleteCategory(category);
    }

}
