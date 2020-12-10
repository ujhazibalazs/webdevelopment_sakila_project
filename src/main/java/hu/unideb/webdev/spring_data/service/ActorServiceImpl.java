package hu.unideb.webdev.spring_data.service;

import hu.unideb.webdev.spring_data.dao.ActorDao;
import hu.unideb.webdev.spring_data.exception.UnknownActorException;
import hu.unideb.webdev.spring_data.model.Actor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@Service
@RequiredArgsConstructor
public class ActorServiceImpl implements ActorService {

    private final ActorDao actorDao;

    @Override
    public Collection<Actor> getAllActor() {
        return actorDao.readAllActor();
    }

    @Override
    public void recordActor(Actor actor) {
        actorDao.createActor(actor);
    }

    @Override
    public void updateActor(Actor original, Actor updated) throws UnknownActorException {
        actorDao.updateActor(original, updated);
    }

    @Override
    public void deleteActor(Actor actor) throws UnknownActorException {
        actorDao.deleteActor(actor);
    }

}
