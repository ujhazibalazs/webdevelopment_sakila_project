package hu.unideb.webdev.spring_data.exception;

import hu.unideb.webdev.spring_data.model.Category;

public class UnknownCategoryException extends Exception {

    private Category category;

    public UnknownCategoryException(Category category) {
        this.category = category;
    }

    public UnknownCategoryException(String message) {
        super(message);
    }

}
