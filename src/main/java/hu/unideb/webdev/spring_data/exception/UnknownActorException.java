package hu.unideb.webdev.spring_data.exception;

import hu.unideb.webdev.spring_data.model.Actor;

public class UnknownActorException extends Exception {

    private Actor actor;

    public UnknownActorException(Actor actor) {
        this.actor = actor;
    }

    public UnknownActorException(String message) {
        super(message);
    }

}
