package hu.unideb.webdev.spring_data.controller;

import hu.unideb.webdev.spring_data.controller.dto.LanguageDeleteRequestDto;
import hu.unideb.webdev.spring_data.controller.dto.LanguageDto;
import hu.unideb.webdev.spring_data.controller.dto.LanguageRecordRequestDto;
import hu.unideb.webdev.spring_data.exception.UnknownLanguageException;
import hu.unideb.webdev.spring_data.model.Language;
import hu.unideb.webdev.spring_data.service.LanguageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LanguageController {

    private final LanguageService languageService;

    @GetMapping("/language")
    public Collection<LanguageDto> listLanguages() {
        return languageService.getAllLanguage()
                .stream()
                .map(model -> LanguageDto.builder()
                        .name(model.getName())
                        .build())
                .collect(Collectors.toList());
    }

    @PostMapping("/language")
    public void recordLanguage(@RequestBody LanguageRecordRequestDto languageRecordRequestDto) {
        languageService.recordLanguage(new Language(
                languageRecordRequestDto.getName()
        ));
    }

    @DeleteMapping("/language")
    public void deleteLanguage(@RequestBody LanguageDeleteRequestDto languageDeleteRequestDto) {
        try {
            languageService.deleteLanguage(new Language(
                    languageDeleteRequestDto.getName()
            ));
        } catch (UnknownLanguageException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

}
