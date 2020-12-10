package hu.unideb.webdev.spring_data.exception;

import hu.unideb.webdev.spring_data.model.Language;

public class UnknownLanguageException extends Exception {

    private Language language;

    public UnknownLanguageException(Language language) {
        this.language = language;
    }

    public UnknownLanguageException(String message) {
        super(message);
    }

}
