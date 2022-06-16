package pl.altkom.scah.ownerservice.repository.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Owner {

    @Id
    @GeneratedValue(generator = "ownerSeq")
    @SequenceGenerator(name = "ownerSeq", sequenceName = "owner_seq", allocationSize = 20)
    private Long id;

    private String firstName;
    private String lastName;
    private String phone;
}
