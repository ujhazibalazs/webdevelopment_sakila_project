package hu.unideb.webdev.spring_data.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ActorRecordRequestDto extends ActorDto {
    private String firstName;
    private String lastName;
}
