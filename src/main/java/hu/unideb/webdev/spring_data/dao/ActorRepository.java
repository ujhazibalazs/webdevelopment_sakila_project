package hu.unideb.webdev.spring_data.dao;

import hu.unideb.webdev.spring_data.dao.entity.ActorEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Optional;

public interface ActorRepository extends CrudRepository<ActorEntity, Integer> {

    @Override
    Optional<ActorEntity> findById(Integer integer);

    //Collection<ActorEntity> findByFirstName(String firstName);

}
