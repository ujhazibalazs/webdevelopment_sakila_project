package hu.unideb.webdev.spring_data.controller;

import hu.unideb.webdev.spring_data.controller.dto.ActorDeleteRequestDto;
import hu.unideb.webdev.spring_data.controller.dto.ActorDto;
import hu.unideb.webdev.spring_data.controller.dto.ActorRecordRequestDto;
import hu.unideb.webdev.spring_data.exception.UnknownActorException;
import hu.unideb.webdev.spring_data.model.Actor;
import hu.unideb.webdev.spring_data.service.ActorService;
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
public class ActorController {

    private final ActorService actorService;

    @GetMapping("/actor")
    public Collection<ActorDto> listActors() {
        return actorService.getAllActor()
                .stream()
                .map(model -> ActorDto.builder()
                        .firstName(model.getFirstName())
                        .lastName(model.getLastName())
                    .build())
                .collect(Collectors.toList());
    }

    @PostMapping("/actor")
    public void recordActor(@RequestBody ActorRecordRequestDto actorRecordRequestDto) {
        actorService.recordActor(new Actor(
                actorRecordRequestDto.getFirstName(),
                actorRecordRequestDto.getLastName()
        ));
    }

    @PutMapping("/actor")
    public void updateActor(@RequestBody ActorDto original, @RequestBody ActorDto updated) {
        try {
            actorService.updateActor(new Actor(
                    original.getFirstName(),
                    original.getLastName()
            ), new Actor(
                    updated.getFirstName(),
                    updated.getLastName()
            ));
        } catch (UnknownActorException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/actor")
    public void deleteActor(@RequestBody ActorDeleteRequestDto actorDeleteRequestDto) {
        try {
            actorService.deleteActor(new Actor(
                    actorDeleteRequestDto.getFirstName(),
                    actorDeleteRequestDto.getLastName()
            ));
        } catch (UnknownActorException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

}
