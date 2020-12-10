package hu.unideb.webdev.spring_data.service;

import hu.unideb.webdev.spring_data.exception.UnknownLanguageException;
import hu.unideb.webdev.spring_data.model.Language;

import java.util.Collection;

public interface LanguageService {

    Collection<Language> getAllLanguage();

    void recordLanguage(Language language);
    void deleteLanguage(Language language) throws UnknownLanguageException;

}
