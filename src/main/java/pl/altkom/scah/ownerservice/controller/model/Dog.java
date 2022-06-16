package pl.altkom.scah.ownerservice.controller.model;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Dog {
    private Long id;

    private String name;
    private String breed;
    private LocalDate dateOfBirth;
    private Long ownerId;
}