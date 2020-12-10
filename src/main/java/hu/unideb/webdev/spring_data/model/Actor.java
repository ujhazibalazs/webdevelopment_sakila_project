package hu.unideb.webdev.spring_data.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Column;

@AllArgsConstructor
@ToString
@Getter
@EqualsAndHashCode
public class Actor {

    private String firstName;
    private String lastName;

}
