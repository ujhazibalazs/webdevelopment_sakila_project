package hu.unideb.webdev.spring_data.dao;

import hu.unideb.webdev.spring_data.dao.entity.ActorEntity;
import hu.unideb.webdev.spring_data.exception.UnknownActorException;
import hu.unideb.webdev.spring_data.model.Actor;
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
public class ActorDaoImpl implements ActorDao {

    private final ActorRepository actorRepository;

    @Override
    public void createActor(Actor actor) {

        ActorEntity actorEntity = null;
        actorEntity = ActorEntity.builder()
                .firstName(actor.getFirstName())
                .lastName(actor.getLastName())
                .lastUpdate(new Timestamp((new Date()).getTime()))
                .build();
        actorRepository.save(actorEntity);

    }

    @Override
    public Collection<Actor> readAllActor() {
        return StreamSupport.stream(actorRepository.findAll().spliterator(), false)
                .map(actorEntity -> new Actor(
                        actorEntity.getFirstName(),
                        actorEntity.getLastName()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public void updateActor(Actor original, Actor updated) throws UnknownActorException {
        Optional<ActorEntity> actorEntity = StreamSupport.stream(actorRepository.findAll().spliterator(), false).filter(
                entity -> {
                    return original.getFirstName().equals(entity.getFirstName()) &&
                            original.getLastName().equals(entity.getLastName());
                }
        ).findAny();
        if(!actorEntity.isPresent()) {
            throw new UnknownActorException(original);
        }
        actorEntity.get().setFirstName(updated.getFirstName());
        actorEntity.get().setLastName(updated.getLastName());
        actorEntity.get().setLastUpdate(new Timestamp((new Date()).getTime()));
        actorRepository.save(actorEntity.get());
    }

    @Override
    public void deleteActor(Actor actor) throws UnknownActorException {
        Optional<ActorEntity> actorEntity = StreamSupport.stream(actorRepository.findAll().spliterator(), false).filter(
                entity -> {
                    return actor.getFirstName().equals(entity.getFirstName()) &&
                            actor.getLastName().equals(entity.getLastName());
                }
        ).findAny();
        if(!actorEntity.isPresent()) {
            throw new UnknownActorException(actor);
        }
        actorRepository.delete(actorEntity.get());
    }


}
