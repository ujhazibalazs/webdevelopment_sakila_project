package hu.unideb.webdev.spring_data.dao;

import hu.unideb.webdev.spring_data.exception.UnknownLanguageException;
import hu.unideb.webdev.spring_data.model.Language;

import java.util.Collection;

public interface LanguageDao {

    void createLanguage(Language language);
    Collection<Language> readAllLanguage();
    void updateLanguage(Language original, Language updated);
    void deleteLanguage(Language language) throws UnknownLanguageException;

}
