package hu.unideb.webdev.spring_data.dao;

import hu.unideb.webdev.spring_data.dao.entity.LanguageEntity;
import hu.unideb.webdev.spring_data.exception.UnknownLanguageException;
import hu.unideb.webdev.spring_data.model.Language;
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
public class LanguageDaoImpl implements LanguageDao {

    private final LanguageRepository languageRepository;

    @Override
    public void createLanguage(Language language) {
        LanguageEntity languageEntity = null;
        languageEntity = LanguageEntity.builder()
                .name(language.getName())
                .lastUpdate(new Timestamp((new Date()).getTime()))
                .build();
        languageRepository.save(languageEntity);
    }

    @Override
    public Collection<Language> readAllLanguage() {
        return StreamSupport.stream(languageRepository.findAll().spliterator(), false)
                .map(languageEntity -> new Language(
                        languageEntity.getName()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public void updateLanguage(Language original, Language updated) {

    }

    @Override
    public void deleteLanguage(Language language) throws UnknownLanguageException {
        Optional<LanguageEntity> languageEntity = StreamSupport.stream(languageRepository.findAll().spliterator(), false).filter(
                entity -> {
                    return language.getName().equals(entity.getName());
                }
        ).findAny();
        if(!languageEntity.isPresent()) {
            throw new UnknownLanguageException(language);
        }
        languageRepository.delete(languageEntity.get());
    }

}
