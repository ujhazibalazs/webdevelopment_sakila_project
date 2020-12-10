package hu.unideb.webdev.spring_data.service;

import hu.unideb.webdev.spring_data.dao.ActorDao;
import hu.unideb.webdev.spring_data.model.Actor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

@ExtendWith(MockitoExtension.class)
class ActorServiceImplTest {

    @InjectMocks
    private ActorServiceImpl service;
    @Mock
    private ActorDao dao;

    @Test
    void testRecordActor() {

        Actor actor = getActor();
        service.recordActor(actor);

        verify(dao, times(1)).createActor(actor);

    }

    @Test
    void testReadAllActor() {

        when(dao.readAllActor()).thenReturn(getDefaultActors());
        Collection<Actor> actual = service.getAllActor();

        assertEquals(actual, getDefaultActors());
        assertThat(getDefaultActors(), is(actual));

    }

    private Actor getActor() {
        return new Actor("First", "Last");
    }

    private Collection<Actor> getDefaultActors() {
        return Arrays.asList(
                new Actor("First1", "Last1"),
                new Actor("First2", "Last2"),
                new Actor("First3", "Last3")
        );
    }

}