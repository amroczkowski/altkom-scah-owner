package pl.altkom.scah.ownerservice.controller.model;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Owner {

    private Long id;

    private String firstName;
    private String lastName;
    private String phone;
    private List<Dog> dogs;
}
