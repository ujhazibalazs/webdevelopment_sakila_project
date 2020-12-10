package hu.unideb.webdev.spring_data.service;

import hu.unideb.webdev.spring_data.exception.UnknownActorException;
import hu.unideb.webdev.spring_data.model.Actor;

import java.util.Collection;

public interface ActorService {

    Collection<Actor> getAllActor();

    void recordActor(Actor actor);
    void deleteActor(Actor actor) throws UnknownActorException;

}
