package hu.unideb.webdev.spring_data.dao;

import hu.unideb.webdev.spring_data.exception.UnknownActorException;
import hu.unideb.webdev.spring_data.model.Actor;

import java.util.Collection;

public interface ActorDao {

    void createActor(Actor actor);
    Collection<Actor> readAllActor();
    void updateActor(Actor original, Actor updated) throws UnknownActorException;
    void deleteActor(Actor actor) throws UnknownActorException;

}
