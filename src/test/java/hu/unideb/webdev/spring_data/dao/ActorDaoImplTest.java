package hu.unideb.webdev.spring_data.dao;

import hu.unideb.webdev.spring_data.model.Actor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

@ExtendWith(MockitoExtension.class)
class ActorDaoImplTest {

    @InjectMocks
    private ActorDaoImpl actorDao;
    @Mock
    private ActorRepository actorRepository;

    @Test
    void testCreateActor() {

        actorDao.createActor(getActor());
        verify(actorRepository, times(1)).save(any());

    }

    private Actor getActor() {
        return new Actor("First", "Last");
    }

}