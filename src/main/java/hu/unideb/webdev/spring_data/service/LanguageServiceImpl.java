package hu.unideb.webdev.spring_data.service;

import hu.unideb.webdev.spring_data.dao.LanguageDao;
import hu.unideb.webdev.spring_data.exception.UnknownLanguageException;
import hu.unideb.webdev.spring_data.model.Language;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Slf4j
@RequiredArgsConstructor
public class LanguageServiceImpl implements LanguageService {

    private final LanguageDao languageDao;

    @Override
    public Collection<Language> getAllLanguage() {
        return languageDao.readAllLanguage();
    }

    @Override
    public void recordLanguage(Language language) {
        languageDao.createLanguage(language);
    }

    @Override
    public void deleteLanguage(Language language) throws UnknownLanguageException {
        languageDao.deleteLanguage(language);
    }

}
